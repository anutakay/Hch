package ru.anutakay.hch.presentation.common.di

import ru.anutakay.hch.presentation.common.navigator.Navigator

interface NavigatorFactory {
    fun <T : Navigator> create(clazz: Class<T>): T
}