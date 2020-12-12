package ru.anutakay.hch.di.features

import dagger.Module
import dagger.Provides
import ru.anutakay.hch.data.common.api.Api
import ru.anutakay.hch.data.login.datasources.LoginApiDataSource
import ru.anutakay.hch.data.login.datasources.LoginApiDataSourceImpl
import ru.anutakay.hch.data.login.repositories.LoginRepositoryImpl
import ru.anutakay.hch.domain.login.repositories.LoginRepository
import ru.anutakay.hch.domain.login.usecases.Login

@Module
class LoginModule {

    @Provides
    fun provideLoginApiDataSource(api: Api): LoginApiDataSource {
        return LoginApiDataSourceImpl(api)
    }

    @Provides
    fun provideLoginRepository(datasource: LoginApiDataSource): LoginRepository {
        return LoginRepositoryImpl(datasource)
    }

    @Provides
    fun provideLoginUseCase(repository: LoginRepository): Login {
        return Login(repository)
    }
}