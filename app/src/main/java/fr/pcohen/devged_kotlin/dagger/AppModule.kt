package fr.pcohen.devged_kotlin.dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import fr.pcohen.devged_kotlin.DevGedApp

@Module(includes = [ViewModelModule::class])
class AppModule {


    @Provides
    fun provideContext(devGedApp: DevGedApp): Context {
        return devGedApp
    }

/*
    @Singleton
    @Provides
    fun provideAppDatabase(applicationContext: Context): AppDatabase
        = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "no-contest-db").build()
*/

}
