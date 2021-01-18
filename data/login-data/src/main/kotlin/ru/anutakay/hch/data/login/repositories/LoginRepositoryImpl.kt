package ru.anutakay.hch.data.login.repositories

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor
import io.reactivex.schedulers.Schedulers
import ru.anutakay.hch.data.login.datasources.LoginApiDataSource
import ru.anutakay.hch.domain.common.*
import ru.anutakay.hch.domain.login.entities.LoginEntity
import ru.anutakay.hch.domain.login.repositories.LoginRepository

class LoginRepositoryImpl(private val apiDataSource: LoginApiDataSource) : LoginRepository {
    override fun login(
        name: String,
        password: String
    ): ResultState {
        val processor = PublishProcessor.create<State>()
        val disposables = CompositeDisposable()

        val request = {
            processor.onNext(LoadingState(true))
            disposables.add(
                apiDataSource.login(LoginEntity(name, password))
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        processor.onNext(LoadingState(false))
                        processor.onNext(SuccessState(it))
                        processor.onComplete()
                    }) {
                        processor.onNext(LoadingState(false))
                        processor.onNext(ErrorState(it))
                    })
            Unit
        }
        return ResultState(
            processor.hide().doOnCancel { disposables.clear() },
            request
        )
    }
}