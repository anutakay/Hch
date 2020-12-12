package ru.anutakay.hch.di.features

import dagger.Module
import dagger.Provides
import ru.anutakay.hch.domain.login.usecases.Login

@Module
class LoginModule {

    @Provides
    fun provideLoginUseCase(): Login {
        return Login()
    }
}