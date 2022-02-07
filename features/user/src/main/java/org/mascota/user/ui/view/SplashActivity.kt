package org.mascota.user.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import org.mascota.home.ui.view.HomeActivity
import org.mascota.user.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHandler()
        setContentView(R.layout.activity_splash)
    }

    private fun setHandler() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startMain()
                finish()
            },
            SPLASH_TIME
        )
    }

    private fun startMain() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    companion object {
        const val SPLASH_TIME = 3000L
    }
}
