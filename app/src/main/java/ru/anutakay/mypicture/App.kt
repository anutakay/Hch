package ru.anutakay.mypicture

import android.app.Application
import ru.anutakay.mypicture.di.AppComponent
import ru.anutakay.mypicture.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .withApplication(this)
            .build()
    }

    companion object {
        @JvmStatic
        lateinit var component: AppComponent
    }
}
