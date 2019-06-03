package fr.pcohen.devged_kotlin.ui.login

import android.widget.Button
import fr.pcohen.devged_kotlin.R
import fr.pcohen.devged_kotlin.shared.common.mvcviews.BaseViewMvc

class LoginActivityMvcImpl : LoginActivityMvc, BaseViewMvc<LoginActivityMvc.Listener>() {

    override fun unregisterListener(listener: LoginActivityMvc.Listener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun buttonLogoutEnabled(enabled: Boolean) {
        findViewById<Button>(R.id.buttonLogout)?.isEnabled = enabled
    }
}