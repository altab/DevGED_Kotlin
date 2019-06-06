package fr.pcohen.devged_kotlin

import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.DaggerApplication
import fr.pcohen.devged_kotlin.dagger.DaggerAppComponent

class DevGedApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }

    override fun applicationInjector() = DaggerAppComponent.factory().create(this)

}