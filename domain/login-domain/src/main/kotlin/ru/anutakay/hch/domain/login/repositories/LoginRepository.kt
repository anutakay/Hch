package ru.anutakay.hch.domain.login.repositories

import ru.anutakay.hch.domain.common.ResultState

interface LoginRepository {
    fun login(): ResultState
}