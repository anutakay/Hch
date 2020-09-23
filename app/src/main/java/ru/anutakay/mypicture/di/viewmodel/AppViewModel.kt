package ru.anutakay.mypicture.di.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.anutakay.mypicture.App

open class AppViewModel(app: Application) : AndroidViewModel(app) {
    protected val application: App = this.getApplication()
}