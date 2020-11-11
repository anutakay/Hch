package ru.anutakay.mypicture.di.app

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ru.anutakay.mypicture.App
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