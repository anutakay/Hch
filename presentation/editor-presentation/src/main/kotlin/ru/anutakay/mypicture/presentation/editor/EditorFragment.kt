package ru.anutakay.mypicture.presentation.editor

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.constraintlayout.widget.ConstraintLayout
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
            viewState().observe { state -> state.percentage.let(::handlePercentage) }
        }
    }

    private fun handlePercentage(percentage: Int) {
        percentage_label.text = percentage.toString()
        seek_bar.progress = percentage

        with(colored_square) {
            layoutParams = (layoutParams as ConstraintLayout.LayoutParams).apply {
                matchConstraintPercentWidth = rescale(percentage)
            }
        }
    }

    private fun rescale(percentage: Int): Float {
        val value = when (percentage) {
            0 -> 1f
            else -> percentage.toFloat()
        }
        return value / 100
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                viewModel.actionStream.onNext(SetPercentageAction(progress, fromUser))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }
}