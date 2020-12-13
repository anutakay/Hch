package ru.anutakay.hch.data.login.repositories

import android.util.Log
import ru.anutakay.hch.data.login.datasources.LoginApiDataSource
import ru.anutakay.hch.domain.common.LoadingState
import ru.anutakay.hch.domain.common.ResultState
import ru.anutakay.hch.domain.common.State
import ru.anutakay.hch.domain.login.entities.LoginEntity
import ru.anutakay.hch.domain.login.repositories.LoginRepository

class LoginRepositoryImpl(private val apiDataSource: LoginApiDataSource) : LoginRepository {
    override fun login(
        name: String,
        password: String
    ): ResultState {
        val login = apiDataSource.login(LoginEntity(name, password))
            .toFlowable()
            .map {
                Log.d("LoginRepository", it.toString())
                LoadingState(true) as State
            }
        return ResultState(login) {}
    }
}