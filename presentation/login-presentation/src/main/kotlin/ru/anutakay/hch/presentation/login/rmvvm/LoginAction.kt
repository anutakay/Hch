package ru.anutakay.hch.presentation.login.rmvvm

import ru.anutakay.hch.presentation.common.Action

sealed class LoginAction: Action

class NextClickedAction(val username: String, val password: String) : LoginAction()