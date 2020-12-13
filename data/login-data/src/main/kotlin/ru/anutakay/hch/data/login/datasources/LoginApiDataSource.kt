package ru.anutakay.hch.data.login.datasources

import io.reactivex.Single
import ru.anutakay.hch.domain.login.entities.AuthorizedUserEntity
import ru.anutakay.hch.domain.login.entities.LoginEntity

interface LoginApiDataSource {
    fun login(body: LoginEntity): Single<AuthorizedUserEntity>
}