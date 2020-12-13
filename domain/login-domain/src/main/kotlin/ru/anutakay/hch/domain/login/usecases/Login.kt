package ru.anutakay.hch.domain.login.usecases

import ru.anutakay.hch.domain.common.ResultState
import ru.anutakay.hch.domain.login.repositories.LoginRepository

class Login(
    private val repository: LoginRepository
) {
    operator fun invoke(username: String, password: String): ResultState =
        repository.login(username, password)
}