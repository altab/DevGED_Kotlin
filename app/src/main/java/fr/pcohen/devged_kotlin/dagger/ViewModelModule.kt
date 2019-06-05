package fr.pcohen.devged_kotlin.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import fr.pcohen.devged_kotlin.ui.ressource.RessourceViewModel
import fr.pcohen.devged_kotlin.viewmodels.DevGedViewModelFactory

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RessourceViewModel::class)
    fun bindRessourceViewModel(passwordResetViewModel: RessourceViewModel): ViewModel


    @Binds
    fun bindViewModelFactory(factory: DevGedViewModelFactory): ViewModelProvider.Factory

}