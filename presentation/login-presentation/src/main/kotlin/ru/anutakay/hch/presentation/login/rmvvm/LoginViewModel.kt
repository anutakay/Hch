package ru.anutakay.hch.presentation.login.rmvvm

import android.util.Log
import io.reactivex.Flowable
import io.reactivex.processors.BehaviorProcessor
import ru.anutakay.hch.presentation.common.BaseViewModel
import ru.anutakay.hch.presentation.common.extention.filterTo
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LoginViewModel @Inject constructor() : BaseViewModel() {

    private val viewState by lazy {
        val processor = BehaviorProcessor.create<LoginViewState>()
        processor.onNext(LoginViewState("1", "a"))
        processor
    }

    init {
        actionStream.filterTo(NextClickedAction::class.java)
            .throttleFirst(1, TimeUnit.SECONDS)
            .subscribe(::nextClicked)
            .track()
    }

    private fun nextClicked(action: NextClickedAction) {
        Log.d("LoginViewModel", "${action.username}|${action.password}")
    }

    fun viewState(): Flowable<LoginViewState> = viewState.hide()
}