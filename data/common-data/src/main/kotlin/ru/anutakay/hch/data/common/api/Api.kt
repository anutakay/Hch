package ru.anutakay.hch.data.common.api

import io.reactivex.Single
import retrofit2.http.POST

interface Api {

    @POST("users/login")
    fun login() : Single<String>
}