package fr.pcohen.devged_kotlin.dagger

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import fr.pcohen.devged_kotlin.DevGedApp
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, MainActivityModule::class])
interface AppComponent : AndroidInjector<DevGedApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: DevGedApp): AppComponent
    }

}