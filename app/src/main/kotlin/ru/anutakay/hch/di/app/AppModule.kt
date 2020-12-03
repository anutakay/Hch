package ru.anutakay.hch.di.app

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ru.anutakay.hch.App
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Singleton
    @Provides
    fun provideApp(): App {
        return app
    }

    @Singleton
    @Provides
    fun provideApplication(): Application {
        return app
    }


    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return app.applicationContext
    }
}