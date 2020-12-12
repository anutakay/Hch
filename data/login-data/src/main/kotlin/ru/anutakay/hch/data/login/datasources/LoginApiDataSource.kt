package ru.anutakay.hch.data.login.datasources

import io.reactivex.Single

interface LoginApiDataSource {

    fun login(): Single<String>
}