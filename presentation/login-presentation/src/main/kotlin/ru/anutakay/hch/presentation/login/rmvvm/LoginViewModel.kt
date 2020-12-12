package ru.anutakay.hch.presentation.login.rmvvm

import android.util.Log
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.processors.BehaviorProcessor
import io.reactivex.processors.PublishProcessor
import ru.anutakay.hch.presentation.common.BaseViewModel
import ru.anutakay.hch.presentation.common.di.NavigatorFactory
import ru.anutakay.hch.presentation.common.extention.filterTo
import ru.anutakay.hch.presentation.common.navigator.Navigator
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val navigatorFactory: NavigatorFactory
) : BaseViewModel() {

    private val navigateViewState = PublishProcessor.create<Navigator>()
    private val viewState by lazy {
        val processor = BehaviorProcessor.create<LoginViewState>()
        processor.onNext(LoginViewState())
        processor
    }

    init {
        actionStream.filterTo(NextClickedAction::class.java)
            .throttleFirst(1, TimeUnit.SECONDS)
            .subscribe(::nextClicked)
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
        Log.d("LoginViewModel", "username: ${action.username}")
        viewState.value?.copy(username = action.username).apply { viewState.onNext(this) }
    }

    private fun passwordInputUpdated(action: PasswordInputUpdatedAction) {
        Log.d("LoginViewModel", "password: ${action.password}")
        viewState.value?.copy(password = action.password).apply { viewState.onNext(this) }
    }

    private fun nextClicked(action: NextClickedAction) {
        Log.d("LoginViewModel", "next: ${viewState.value?.username}|${viewState.value?.password}")
    }

    fun viewState(): Flowable<LoginViewState> = viewState.hide()

    fun navigateViewState(): Flowable<Navigator> = navigateViewState.hide()
}