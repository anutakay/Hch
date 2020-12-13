package ru.anutakay.hch.data.common.api

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ru.anutakay.hch.data.common.api.entities.AuthorizedUserDto
import ru.anutakay.hch.data.common.api.entities.LoginDto

interface Api {
    @POST("users/login")
    fun login(@Body user: LoginDto): Single<Response<AuthorizedUserDto>>
}