package ru.anutakay.hch.di.navigator

import dagger.MapKey
import ru.anutakay.hch.presentation.common.navigator.Navigator
import kotlin.reflect.KClass

@MapKey
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class NavigatorKey(val value: KClass<out Navigator>)