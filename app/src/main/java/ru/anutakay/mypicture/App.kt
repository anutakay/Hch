package ru.anutakay.mypicture

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import ru.anutakay.mypicture.di.app.AppModule
import ru.anutakay.mypicture.di.app.DaggerAppComponent

class App : DaggerApplication() {

    private val applicationInjector by lazy {
        DaggerAppComponent.builder().setAppModule(AppModule(this)).create(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector
}
