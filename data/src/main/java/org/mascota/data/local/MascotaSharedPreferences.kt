package org.mascota.data.local

import android.content.Context
import androidx.core.content.edit
import androidx.databinding.ktx.BuildConfig
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import javax.inject.Inject

class MascotaSharedPreferences @Inject constructor(
    context: Context
) {
    private val preferences = if (!BuildConfig.DEBUG) EncryptedSharedPreferences.create(
        FILE_NAME,
        MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    ) else context.getSharedPreferences(DEBUG_FILE_NAME, Context.MODE_PRIVATE)

    var userToken: String
        set(value) = preferences.edit { putString(USER_TOKEN, value) }
        get() = preferences.getString(USER_TOKEN, "") ?: ""

    companion object {
        private const val USER_TOKEN = "USER_TOKEN"
        private const val FILE_NAME = "MASCOTAAUTH"
        const val DEBUG_FILE_NAME = "MASCOTAAUTHDEBUG"
    }
}
