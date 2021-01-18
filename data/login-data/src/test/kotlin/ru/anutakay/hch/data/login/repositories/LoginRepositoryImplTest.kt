package ru.anutakay.hch.data.login.repositories

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.TestSubscriber
import org.junit.Test
import org.mockito.Mockito
import ru.anutakay.hch.data.login.datasources.LoginApiDataSource
import ru.anutakay.hch.domain.common.LoadingState
import ru.anutakay.hch.domain.common.State
import ru.anutakay.hch.domain.common.SuccessState
import ru.anutakay.hch.domain.login.entities.AuthorizedUserEntity
import ru.anutakay.hch.domain.login.entities.LoginEntity

class LoginRepositoryImplTest {

    @Test
    fun login() {
        val body = LoginEntity("username", "password")
        val expectedBody = AuthorizedUserEntity("1", "username", "password")

        val mockDataSource = Mockito.mock(LoginApiDataSource::class.java)
        Mockito.`when`(mockDataSource.login(body)).thenReturn(Single.just(expectedBody))
        val repositoryImpl = LoginRepositoryImpl(mockDataSource)
        val resultState = repositoryImpl.login("username", "password")

        val subscriber = TestSubscriber<State>()
        resultState.stateStream
            .subscribeOn(Schedulers.io())
            .subscribe(subscriber)
        resultState.request()
        subscriber.await()
        subscriber.assertValues(LoadingState(true), LoadingState(false), SuccessState(expectedBody))
        subscriber.assertComplete()

        Mockito.verify(mockDataSource, Mockito.times(1)).login(body)
    }
}