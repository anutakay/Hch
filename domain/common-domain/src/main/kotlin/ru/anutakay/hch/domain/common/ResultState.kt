package ru.anutakay.hch.domain.common

import io.reactivex.Flowable

data class ResultState(
    val stateStream: Flowable<State>,
    val callback: () -> Unit
)

sealed class State
data class LoadingState(val loading: Boolean) : State()
data class ErrorState(val throwable: Throwable) : State()