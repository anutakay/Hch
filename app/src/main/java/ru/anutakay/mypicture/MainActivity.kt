package ru.anutakay.mypicture;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.anutakay.mypicture.presentation.ui.picture.PictureFragment

class MainActivity : AppCompatActivity(),
    PictureFragment.InteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
    }
}
