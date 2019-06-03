package fr.pcohen.devged_kotlin.ui.login

import fr.pcohen.devged_kotlin.shared.common.mvcviews.ObservableViewMvc

interface LoginActivityMvc : ObservableViewMvc<LoginActivityMvc.Listener> {

    fun onDestroy()
    fun buttonLogoutEnabled(enabled: Boolean)

    interface Listener
}