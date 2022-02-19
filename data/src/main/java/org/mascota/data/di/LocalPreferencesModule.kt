package org.mascota.data.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import org.mascota.data.local.MascotaSharedPreferences

@Module
@InstallIn(SingletonComponent::class)
object LocalPreferencesModule {
    @Provides
    @Singleton
    fun providesLocalPreferences(@ApplicationContext context: Application) =
        MascotaSharedPreferences(context)
}
