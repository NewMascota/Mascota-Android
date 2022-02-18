package org.mascota

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.mascota.core.util.MascotaDebugTree
import org.mascota.mascota.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class MascotaApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG)
            Timber.plant(MascotaDebugTree())
    }
}
