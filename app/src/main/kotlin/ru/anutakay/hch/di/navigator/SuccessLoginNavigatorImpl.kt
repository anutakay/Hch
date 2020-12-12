package ru.anutakay.hch.di.navigator

import androidx.navigation.NavController
import ru.anutakay.hch.presentation.common.navigator.SuccessLoginNavigator
import javax.inject.Inject

class SuccessLoginNavigatorImpl @Inject constructor() : SuccessLoginNavigator {

    override fun launchFragment(nav: NavController) {
       // nav.navigate()
    }
}