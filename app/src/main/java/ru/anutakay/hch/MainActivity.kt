package ru.anutakay.hch;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.anutakay.hch.presentation.ui.picture.PictureFragment

class MainActivity : AppCompatActivity(),
    PictureFragment.InteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
    }
}
