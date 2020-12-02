package ru.anutakay.hch.di.app

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.anutakay.hch.App
import ru.anutakay.hch.di.viewmodel.ViewModelModule
import ru.anutakay.hch.presentation.editor.di.EditorFragmentModule
import ru.anutakay.hch.presentation.timer.di.TimerFragmentModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        MainActivityModule::class,
        ViewModelModule::class,
        EditorFragmentModule::class,
        TimerFragmentModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        abstract fun setAppModule(module: AppModule): Builder
    }
}