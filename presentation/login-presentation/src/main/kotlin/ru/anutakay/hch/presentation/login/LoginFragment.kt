package ru.anutakay.hch.presentation.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.login.*
import ru.anutakay.hch.presentation.common.BaseFragment
import ru.anutakay.hch.presentation.login.rmvvm.LoginViewModel
import ru.anutakay.hch.presentation.login.rmvvm.NextClickedAction
import ru.anutakay.hch.presentation.login.rmvvm.PasswordInputUpdatedAction
import ru.anutakay.hch.presentation.login.rmvvm.UsernameInputUpdatedAction

class LoginFragment : BaseFragment() {

    override fun layoutId(): Int = R.layout.login

    private lateinit var viewModel: LoginViewModel
    private lateinit var usernameTextWatcher: TextWatcher
    private lateinit var passwordTextWatcher: TextWatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = viewModel(viewModelFactory) {
            viewState().observe { state ->
                state.username.let(::handleUsername)
                state.password.let(::handlePassword)
            }
        }
        usernameTextWatcher = object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                viewModel.actionStream.onNext(
                    UsernameInputUpdatedAction(username_edit_text.text.toString())
                )
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
        }

        passwordTextWatcher = object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                viewModel.actionStream.onNext(
                    PasswordInputUpdatedAction(password_edit_text.text.toString())
                )
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
        }
    }

    private fun handleUsername(username: String?) {
        if (username_edit_text.text.toString() == username) return
        with(username_edit_text) {
            removeTextChangedListener(usernameTextWatcher)
            setText(username)
            setSelection(username?.length ?: 0)
            addTextChangedListener(usernameTextWatcher)
        }
    }

    private fun handlePassword(password: String?) {
        if (password_edit_text.text.toString() == password) return
        with(password_edit_text) {
            removeTextChangedListener(passwordTextWatcher)
            setText(password)
            setSelection(password?.length ?: 0)
            addTextChangedListener(passwordTextWatcher)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        username_edit_text.addTextChangedListener(usernameTextWatcher)
        password_edit_text.addTextChangedListener(passwordTextWatcher)
        next_button.setOnClickListener {
            viewModel.actionStream.onNext(NextClickedAction)
        }
    }
}