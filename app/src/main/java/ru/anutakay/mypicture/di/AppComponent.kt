package ru.anutakay.mypicture.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import ru.anutakay.mypicture.App
import ru.anutakay.mypicture.presentation.ui.picture.PictureFragment
import javax.inject.Singleton


@Singleton
@Component(modules = [ViewModelModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun withApplication(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(fragment: PictureFragment)
}