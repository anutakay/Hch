package ru.anutakay.hch.di.navigator

import androidx.navigation.NavController
import ru.anutakay.hch.presentation.common.navigator.SuccessLoginNavigator
import ru.anutakay.hch.presentation.login.LoginFragmentDirections
import javax.inject.Inject

class SuccessLoginNavigatorImpl @Inject constructor() : SuccessLoginNavigator {

    override fun launchFragment(nav: NavController) {
        nav.navigate(LoginFragmentDirections.actionSuccessLogin())
    }
}