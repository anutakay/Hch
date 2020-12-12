package ru.anutakay.hch.presentation.login.rmvvm

import ru.anutakay.hch.presentation.common.Action

sealed class LoginAction : Action

object NextClickedAction : LoginAction()
class UsernameInputUpdatedAction(val username: String) : LoginAction()
class PasswordInputUpdatedAction(val password: String) : LoginAction()