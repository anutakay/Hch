package ru.anutakay.hch.domain.login.usecases

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import ru.anutakay.hch.domain.common.LoadingState
import ru.anutakay.hch.domain.common.ResultState
import ru.anutakay.hch.domain.common.State

class Login {
    operator fun invoke(username: String, password: String): ResultState {
        return ResultState(Flowable.create<State>({ emitter ->
            emitter.onNext(LoadingState(true))
            Thread.sleep(1000)
            emitter.onNext(LoadingState(false))
            emitter.onComplete()
        }, BackpressureStrategy.LATEST))
    }
}