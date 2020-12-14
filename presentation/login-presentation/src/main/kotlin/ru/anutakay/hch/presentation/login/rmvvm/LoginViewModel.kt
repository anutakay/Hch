package ru.anutakay.hch.presentation.login.rmvvm

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.processors.BehaviorProcessor
import io.reactivex.processors.PublishProcessor
import io.reactivex.schedulers.Schedulers
import ru.anutakay.hch.domain.common.ErrorState
import ru.anutakay.hch.domain.common.LoadingState
import ru.anutakay.hch.domain.common.ResultState
import ru.anutakay.hch.domain.common.SuccessState
import ru.anutakay.hch.domain.login.usecases.Login
import ru.anutakay.hch.presentation.common.BaseViewModel
import ru.anutakay.hch.presentation.common.di.NavigatorFactory
import ru.anutakay.hch.presentation.common.extention.filterTo
import ru.anutakay.hch.presentation.common.navigator.Navigator
import ru.anutakay.hch.presentation.common.navigator.SuccessLoginNavigator
import ru.anutakay.hch.presentation.login.R
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val login: Login,
    private val navigatorFactory: NavigatorFactory
) : BaseViewModel() {

    private val navigateViewState = PublishProcessor.create<Navigator>()
    private val viewState by lazy {
        val processor = BehaviorProcessor.create<LoginViewState>()
        processor.onNext(LoginViewState(username = "", password = "", loading = false))
        processor
    }

    init {
        actionStream.filterTo(NextClickedAction::class.java)
            .throttleFirst(1, TimeUnit.SECONDS)
            .toFlowable(BackpressureStrategy.LATEST)
            .flatMap(::nextClicked)
            .subscribe(viewState::onNext)
            .track()

        actionStream.filterTo(UsernameInputUpdatedAction::class.java)
            .toFlowable(BackpressureStrategy.LATEST)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::usernameInputUpdated)
            .track()

        actionStream.filterTo(PasswordInputUpdatedAction::class.java)
            .toFlowable(BackpressureStrategy.LATEST)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::passwordInputUpdated)
            .track()
    }

    private fun usernameInputUpdated(action: UsernameInputUpdatedAction) {
        viewState.value?.copy(username = action.username).apply { viewState.onNext(this) }
    }

    private fun passwordInputUpdated(action: PasswordInputUpdatedAction) {
        viewState.value?.copy(password = action.password).apply { viewState.onNext(this) }
    }

    private fun nextClicked(
        @Suppress("UNUSED_PARAMETER") action: NextClickedAction
    ): Flowable<LoginViewState> {
        val resultState: ResultState = login(
            viewState.value?.username ?: "",
            viewState.value?.password ?: ""
        ).apply { request() }

        return resultState.stateStream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                when (it) {
                    is LoadingState -> viewState.value!!.copy(loading = it.loading)
                    is SuccessState -> {
                        navigateToNextPage()
                        viewState.value!!.copy(errorMessage = 0, error = null)
                    }
                    is ErrorState -> {
                        it.throwable.printStackTrace()
                        viewState.value!!.copy(
                            errorMessage = R.string.error_happened,
                            error = it.throwable
                        )
                    }
                }
            }
    }

    private fun navigateToNextPage() {
        val navigator = navigatorFactory.create(SuccessLoginNavigator::class.java)
        navigateViewState.onNext(navigator)
    }

    fun viewState(): Flowable<LoginViewState> = viewState.hide()

    fun navigateViewState(): Flowable<Navigator> = navigateViewState.hide()
}