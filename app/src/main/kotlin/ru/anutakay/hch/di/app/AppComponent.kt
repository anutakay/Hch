package ru.anutakay.hch.di.app

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.anutakay.hch.App
import ru.anutakay.hch.data.common.di.NetworkModule
import ru.anutakay.hch.di.features.LoginModule
import ru.anutakay.hch.di.navigator.NavigatorModule
import ru.anutakay.hch.di.viewmodel.ViewModelModule
import ru.anutakay.hch.presentation.editor.di.EditorFragmentModule
import ru.anutakay.hch.presentation.login.di.LoginFragmentModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        MainActivityModule::class,
        ViewModelModule::class,
        NavigatorModule::class,
        EditorFragmentModule::class,
        LoginFragmentModule::class,
        LoginModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        abstract fun setAppModule(module: AppModule): Builder
    }
}