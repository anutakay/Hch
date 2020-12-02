package ru.anutakay.hch.presentation.common.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class AppViewModel(app: Application) : AndroidViewModel(app) {
    protected val app: Application = this.getApplication()
}