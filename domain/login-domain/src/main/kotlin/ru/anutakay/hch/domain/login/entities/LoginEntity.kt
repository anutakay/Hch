package ru.anutakay.hch.domain.login.entities

import ru.anutakay.hch.domain.common.Entity

data class LoginEntity(
    val name: String,
    val password: String
) : Entity