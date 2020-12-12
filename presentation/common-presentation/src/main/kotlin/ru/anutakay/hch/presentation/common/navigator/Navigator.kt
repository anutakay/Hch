package ru.anutakay.hch.presentation.common.navigator

import androidx.navigation.NavController

interface Navigator {
    fun launchFragment(nav: NavController)
}