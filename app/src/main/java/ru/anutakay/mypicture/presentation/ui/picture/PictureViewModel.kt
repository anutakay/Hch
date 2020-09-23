package ru.anutakay.mypicture.presentation.ui.picture;

import android.app.Application
import ru.anutakay.mypicture.di.viewmodel.AppViewModel
import javax.inject.Inject;

class PictureViewModel
@Inject constructor(app: Application) : AppViewModel(app) {
}
