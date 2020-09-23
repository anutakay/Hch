package ru.anutakay.mypicture.presentation.ui.picture

import androidx.fragment.app.Fragment
import ru.anutakay.mypicture.presentation.ui.SingleFragmentActivity

class PictureActivity : SingleFragmentActivity(), PictureFragment.InteractionListener {

    override fun createFragment(): Fragment = PictureFragment.newInstance()
}