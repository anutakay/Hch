package ru.anutakay.hch.data.common.api.entities

import com.google.gson.annotations.SerializedName

data class LoginDto (
    @SerializedName("name") val name: String,
    @SerializedName("password") val password: String
)