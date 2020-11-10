package ru.anutakay.mypicture.presentation.common.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class AppViewModel(app: Application) : AndroidViewModel(app) {
    protected val app: Application = this.getApplication()
}