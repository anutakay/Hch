package ru.anutakay.hch.di.navigator

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.anutakay.hch.presentation.common.di.NavigatorFactory
import ru.anutakay.hch.presentation.common.di.NavigatorFactoryImpl
import ru.anutakay.hch.presentation.common.navigator.Navigator
import ru.anutakay.hch.presentation.common.navigator.SuccessLoginNavigator

@Module
abstract class NavigatorModule {
    @Binds
    internal abstract fun bindNavigatorFactory(factory: NavigatorFactoryImpl): NavigatorFactory

    @Binds
    @IntoMap
    @NavigatorKey(SuccessLoginNavigator::class)
    abstract fun bindsAlbumDetailsNavigator(navigator: SuccessLoginNavigatorImpl): Navigator
}