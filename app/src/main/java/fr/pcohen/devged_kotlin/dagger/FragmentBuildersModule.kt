package fr.pcohen.devged_kotlin.dagger


import dagger.Module
import dagger.android.ContributesAndroidInjector
import fr.pcohen.devged_kotlin.ui.ressource.RessourceFragment

@Module
interface FragmentBuildersModule {


    @ContributesAndroidInjector
    fun contributeRessourceFragment(): RessourceFragment

}