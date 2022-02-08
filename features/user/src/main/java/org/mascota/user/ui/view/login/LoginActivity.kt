package org.mascota.user.ui.view.login

import android.content.Intent
import android.os.Bundle
import org.mascota.core.base.BindingActivity
import org.mascota.home.ui.view.HomeActivity
import org.mascota.user.R
import org.mascota.user.databinding.ActivityLoginBinding

class LoginActivity : BindingActivity<ActivityLoginBinding>(R.layout.activity_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initClickEvent()
    }

    private fun initClickEvent() {
        binding.btnLogin.setOnClickListener {
            startMain()
        }
    }

    private fun startMain() {
        startActivity(Intent(this, HomeActivity::class.java))
    }
}
