package fr.pcohen.devged_kotlin.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import fr.pcohen.devged_kotlin.MainActivity

@Module
interface MainActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    fun contributeMainActivity(): MainActivity

}