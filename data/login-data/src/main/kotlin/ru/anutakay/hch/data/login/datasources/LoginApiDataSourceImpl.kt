package ru.anutakay.hch.data.login.datasources

import io.reactivex.Single
import ru.anutakay.hch.data.common.api.Api

class LoginApiDataSourceImpl (private val api: Api) : LoginApiDataSource {

    override fun login(): Single<String> = api.login()
}