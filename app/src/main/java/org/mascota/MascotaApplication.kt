package org.mascota

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MascotaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
