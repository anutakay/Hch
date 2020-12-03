package ru.anutakay.hch

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import ru.anutakay.hch.di.app.AppModule
import ru.anutakay.hch.di.app.DaggerAppComponent

class App : DaggerApplication() {

    private val applicationInjector by lazy {
        DaggerAppComponent.builder().setAppModule(AppModule(this)).create(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector
}
