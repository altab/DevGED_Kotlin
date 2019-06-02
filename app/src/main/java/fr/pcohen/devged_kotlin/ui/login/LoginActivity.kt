package fr.pcohen.devged_kotlin.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.pcohen.devged_kotlin.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginActivityMvc.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(toolbar)
    }
}
