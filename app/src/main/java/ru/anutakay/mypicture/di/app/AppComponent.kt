package ru.anutakay.mypicture.di.app

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.anutakay.mypicture.App
import ru.anutakay.mypicture.di.viewmodel.ViewModelModule
import ru.anutakay.mypicture.presentation.editor.di.EditorFragmentModule
import ru.anutakay.mypicture.presentation.timer.di.TimerFragmentModule
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