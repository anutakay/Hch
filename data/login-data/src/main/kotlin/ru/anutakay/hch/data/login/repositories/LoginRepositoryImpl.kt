package ru.anutakay.hch.data.login.repositories

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import ru.anutakay.hch.data.login.datasources.LoginApiDataSource
import ru.anutakay.hch.domain.common.LoadingState
import ru.anutakay.hch.domain.common.ResultState
import ru.anutakay.hch.domain.common.State
import ru.anutakay.hch.domain.login.repositories.LoginRepository

class LoginRepositoryImpl(val apiDataSource: LoginApiDataSource) : LoginRepository {
    override fun login(): ResultState {
        return ResultState(Flowable.create<State>({ emitter ->
            emitter.onNext(LoadingState(true))
            Thread.sleep(1000)
            emitter.onNext(LoadingState(false))
            emitter.onComplete()
        }, BackpressureStrategy.LATEST))
    }
}