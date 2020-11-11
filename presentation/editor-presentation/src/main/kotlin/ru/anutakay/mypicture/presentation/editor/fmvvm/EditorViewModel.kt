package ru.anutakay.mypicture.presentation.editor.fmvvm

import io.reactivex.Flowable
import io.reactivex.processors.BehaviorProcessor
import ru.anutakay.mypicture.presentation.common.BaseViewModel
import javax.inject.Inject

class EditorViewModel @Inject constructor() : BaseViewModel() {

    private val viewState by lazy {
        val processor = BehaviorProcessor.create<EditorViewState>()
        processor.onNext(EditorViewState(50))
        processor
    }

    fun viewState(): Flowable<EditorViewState> = viewState.hide()
}