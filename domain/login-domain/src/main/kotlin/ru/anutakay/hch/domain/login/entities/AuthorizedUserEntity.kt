package ru.anutakay.hch.domain.login.entities

import ru.anutakay.hch.domain.common.Entity

class AuthorizedUserEntity(
    val id: String,
    val name: String,
    val password: String
) : Entity