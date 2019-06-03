package fr.pcohen.devged_kotlin.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import fr.pcohen.devged_kotlin.R
import fr.pcohen.devged_kotlin.library.extensions.toTreatFor
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.content_login.*
import java.util.*

class LoginActivity : AppCompatActivity(), LoginActivityMvc.Listener {

    companion object {
        private const val TAG = "LoginActivity"
    }

    private var mViewMvc: LoginActivityMvc? = null
    private val REQUESTCODE: Int = 1984
    lateinit var providers: List<AuthUI.IdpConfig>

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)
            setSupportActionBar(toolbar)

            // Init
            providers = Arrays.asList<AuthUI.IdpConfig>(
                AuthUI.IdpConfig.EmailBuilder().build(),
                AuthUI.IdpConfig.FacebookBuilder().build(),
                AuthUI.IdpConfig.GoogleBuilder().build()
                //          ,AuthUI.IdpConfig.PhoneBuilder().build()
            )
            showSignInOptions()

            buttonLogout.setOnClickListener {
                AuthUI.getInstance().signOut(this@LoginActivity)
                    .addOnCompleteListener {
                        //buttonLogout.isEnabled = false
                        mViewMvc?.buttonLogoutEnabled(false)
                        showSignInOptions()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this@LoginActivity, e.message, Toast.LENGTH_SHORT).show()
                    }
            }
        } catch (exception: Exception) {
            exception.toTreatFor(TAG)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        try {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == REQUESTCODE) {
                val response = IdpResponse.fromResultIntent(data)
                if (resultCode == Activity.RESULT_OK) {
                    val user = FirebaseAuth.getInstance().currentUser
                    Toast.makeText(this, "OK, " + user?.email, Toast.LENGTH_SHORT).show()
                    //buttonLogout.isEnabled = true
                    mViewMvc?.buttonLogoutEnabled(true)
                } else {
                    Toast.makeText(this, "KO, " + response?.error?.message, Toast.LENGTH_SHORT).show()
                }
            }
        } catch (exception: Exception) {
            exception.toTreatFor(TAG)
        }
    }

    private fun showSignInOptions() {
        try {
            startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .setTheme(R.style.DevGED)
                    .setTheme(R.style.AppTheme_NoActionBar)
                    .build(), REQUESTCODE
            )
        } catch (exception: Exception) {
            exception.toTreatFor(TAG)
        }
    }

}
