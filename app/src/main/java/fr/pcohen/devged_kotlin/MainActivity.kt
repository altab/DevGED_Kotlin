package fr.pcohen.devged_kotlin

import android.content.pm.ActivityInfo
import android.os.Bundle
import fr.pcohen.devged_kotlin.base.BaseActivity


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
}
