package org.mascota.data.network

import javax.inject.Inject
import okhttp3.Interceptor
import okhttp3.Response
import org.mascota.data.local.MascotaSharedPreferences

class AuthInterceptor @Inject constructor(private val preferences: MascotaSharedPreferences) :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        preferences.userToken.let {
            requestBuilder.addHeader("x-access-token", it)
        }

        return chain.proceed(requestBuilder.build())
    }
}
