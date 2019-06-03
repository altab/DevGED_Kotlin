package fr.pcohen.devged_kotlin.dagger

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import fr.pcohen.devged_kotlin.viewmodels.DevGedViewModelFactory

@Module
interface ViewModelModule {
/*
    @Binds
    @IntoMap
    @ViewModelKey(PasswordResetViewModel::class)
    fun bindPasswordResetViewModel(passwordResetViewModel: PasswordResetViewModel): ViewModel
*/

    @Binds
    fun bindViewModelFactory(factory: DevGedViewModelFactory): ViewModelProvider.Factory

}