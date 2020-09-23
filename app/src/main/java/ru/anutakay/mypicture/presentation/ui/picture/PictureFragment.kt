package ru.anutakay.mypicture.presentation.ui.picture

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.anutakay.mypicture.App
import ru.anutakay.mypicture.R
import ru.anutakay.mypicture.di.viewmodel.AppViewModelFactory
import javax.inject.Inject

class PictureFragment : Fragment() {
    private var outputPort: InteractionListener? = null

    @Inject
    lateinit var factory: AppViewModelFactory
    lateinit var viewModel: PictureViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is InteractionListener) {
            outputPort = context
        } else {
            throw RuntimeException("$context must implement InteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        outputPort = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.component.inject(this)
        viewModel = ViewModelProvider(this, factory)[PictureViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_picture, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {

        }
    }

    interface InteractionListener {

    }

    companion object {
        @JvmStatic
        fun newInstance() = PictureFragment()
    }
}