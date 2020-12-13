package ru.anutakay.hch.data.login.repositories

import ru.anutakay.hch.data.login.datasources.LoginApiDataSource
import ru.anutakay.hch.domain.common.LoadingState
import ru.anutakay.hch.domain.common.ResultState
import ru.anutakay.hch.domain.common.State
import ru.anutakay.hch.domain.login.entities.LoginEntity
import ru.anutakay.hch.domain.login.repositories.LoginRepository

class LoginRepositoryImpl(private val apiDataSource: LoginApiDataSource) : LoginRepository {
    override fun login(): ResultState {
        val login = apiDataSource.login(LoginEntity("super_general", "pass"))
            .toFlowable()
            .map { LoadingState(true) as State }

        /* val stateStream = Flowable.create<State>({ emitter ->
             emitter.onNext(LoadingState(true))
             Thread.sleep(1000)
             emitter.onNext(LoadingState(false))
             emitter.onComplete()
         }, BackpressureStrategy.LATEST)*/

        return ResultState(login)
    }
}