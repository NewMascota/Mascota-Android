package org.mascota.user.ui.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import org.mascota.core.util.extension.setStatusBarColor
import org.mascota.user.R
import org.mascota.user.ui.view.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColor(getColor(R.color.maco_orange))
        setHandler()
        setContentView(R.layout.activity_splash)
    }

    private fun setHandler() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startLogin()
                finish()
            },
            SPLASH_TIME
        )
    }

    private fun startLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    companion object {
        const val SPLASH_TIME = 3000L
    }
}
