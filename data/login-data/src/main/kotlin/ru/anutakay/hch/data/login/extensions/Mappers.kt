package ru.anutakay.hch.data.login.extensions

import ru.anutakay.hch.data.common.api.entities.AuthorizedUserDto
import ru.anutakay.hch.data.common.api.entities.LoginDto
import ru.anutakay.hch.domain.login.entities.AuthorizedUserEntity
import ru.anutakay.hch.domain.login.entities.LoginEntity

fun LoginDto.map() = LoginEntity(
    name = name,
    password = password
)

fun LoginEntity.map() = LoginDto(
    name = name,
    password = password
)

fun AuthorizedUserDto.map() = AuthorizedUserEntity(
    id = id,
    name = name,
    password = password
)

fun AuthorizedUserEntity.map() = AuthorizedUserDto(
    id = id,
    name = name,
    password = password
)