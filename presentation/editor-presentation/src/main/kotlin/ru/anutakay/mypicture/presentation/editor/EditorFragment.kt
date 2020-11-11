package ru.anutakay.mypicture.presentation.editor

import android.os.Bundle
import kotlinx.android.synthetic.main.editor.*
import ru.anutakay.mypicture.presentation.common.BaseFragment
import ru.anutakay.mypicture.presentation.editor.fmvvm.EditorViewModel

class EditorFragment : BaseFragment() {

    override fun layoutId(): Int = R.layout.editor

    private lateinit var viewModel: EditorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = viewModel(viewModelFactory)

        viewModel.viewState().observe { state ->
            handlePercentage(state.percentage)
        }
    }

    private fun handlePercentage(percentage: Int) {
        percentage_label.text = percentage.toString()
        seek_bar.progress = percentage
    }
}