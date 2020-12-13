package ru.anutakay.hch.data.login.datasources

import io.reactivex.Single
import ru.anutakay.hch.data.common.api.Api
import ru.anutakay.hch.data.common.api.entities.AuthorizedUserDto
import ru.anutakay.hch.data.login.extensions.map
import ru.anutakay.hch.domain.login.entities.AuthorizedUserEntity
import ru.anutakay.hch.domain.login.entities.LoginEntity

class LoginApiDataSourceImpl(private val api: Api) : LoginApiDataSource {
    override fun login(body: LoginEntity): Single<AuthorizedUserEntity> =
        api.login(body.map()).map {
            when (it.isSuccessful) {
                true -> return@map (it.body() as AuthorizedUserDto).map()
                else -> throw RuntimeException("Test exception ${it.message()}")
            }
        }
}