package ru.anutakay.hch.presentation.login.rmvvm

import androidx.annotation.StringRes

data class LoginViewState(
    val username: String,
    val password: String,
    val loading: Boolean,
    @StringRes val errorMessage: Int = 0,
    val error: Throwable? = null
)