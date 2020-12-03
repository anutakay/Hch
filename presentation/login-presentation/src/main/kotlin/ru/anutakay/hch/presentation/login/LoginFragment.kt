package ru.anutakay.hch.presentation.login

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.login.*
import ru.anutakay.hch.presentation.common.BaseFragment
import ru.anutakay.hch.presentation.login.rmvvm.LoginViewModel
import ru.anutakay.hch.presentation.login.rmvvm.NextClickedAction

class LoginFragment : BaseFragment() {

    override fun layoutId(): Int = R.layout.login

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = viewModel(viewModelFactory) {
            viewState().observe { state ->
                state.username?.let { username_edit_text.setText(it) }
                state.password?.let { password_edit_text.setText(it) }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        next_button.setOnClickListener {
            viewModel.actionStream.onNext(
                NextClickedAction(
                    username_edit_text.text.toString(),
                    password_edit_text.text.toString()
                )
            )
        }
    }
}