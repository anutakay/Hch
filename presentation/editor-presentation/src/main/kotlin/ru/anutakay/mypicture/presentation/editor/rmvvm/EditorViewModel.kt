package ru.anutakay.mypicture.presentation.editor.rmvvm

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.processors.BehaviorProcessor
import ru.anutakay.mypicture.presentation.common.BaseViewModel
import ru.anutakay.mypicture.presentation.common.extention.filterTo
import javax.inject.Inject

class EditorViewModel @Inject constructor() : BaseViewModel() {

    private val viewState by lazy {
        val processor = BehaviorProcessor.create<EditorViewState>()
        processor.onNext(EditorViewState(50))
        processor
    }

    init {
        actionStream.filterTo(SetPercentageAction::class.java)
            .filter { it.fromUser }
            .toFlowable(BackpressureStrategy.LATEST)
            .subscribe { action ->
                viewState.value?.let {
                    viewState.onNext(it.copy(percentage = action.percentage))
                }
            }
            .track()
    }

    fun viewState(): Flowable<EditorViewState> = viewState.hide()
}