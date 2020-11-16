package ru.anutakay.mypicture.presentation.editor

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.editor.*
import ru.anutakay.mypicture.presentation.common.BaseFragment
import ru.anutakay.mypicture.presentation.editor.rmvvm.EditorViewModel
import ru.anutakay.mypicture.presentation.editor.rmvvm.SetPercentageAction

class EditorFragment : BaseFragment() {

    override fun layoutId(): Int = R.layout.editor

    private lateinit var viewModel: EditorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = viewModel(viewModelFactory) {
            viewState().observe { state ->
                state.percentage.let { handlePercentage(it) }
            }
        }
    }

    private fun handlePercentage(percentage: Int) {
        percentage_label.text = percentage.toString()
        seek_bar.progress = percentage
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                viewModel.actionStream.onNext(SetPercentageAction(p1))
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
    }
}