package ru.anutakay.hch.presentation.common.di

import ru.anutakay.hch.presentation.common.navigator.Navigator
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
@Suppress("UNCHECKED_CAST")
class NavigatorFactoryImpl
@Inject constructor(
    private val creators: Map<Class<out Navigator>, @JvmSuppressWildcards Provider<Navigator>>
) : NavigatorFactory {

    override fun <T : Navigator> create(clazz: Class<T>): T {
        val creator =
            creators[clazz] ?: creators.asIterable()
                .firstOrNull { clazz.isAssignableFrom(it.key) }?.value
            ?: throw IllegalArgumentException("Unknown Navigator class $clazz")

        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}