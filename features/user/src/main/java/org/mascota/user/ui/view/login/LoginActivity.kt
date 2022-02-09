package org.mascota.user.ui.view.login

import android.content.Intent
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import org.mascota.core.base.BindingActivity
import org.mascota.home.ui.view.HomeActivity
import org.mascota.user.R
import org.mascota.user.databinding.ActivityLoginBinding

class LoginActivity : BindingActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private var isValidEmail = false
    private var isValidPassword = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initClickEvent()
        isEmailAndPasswordValid()
    }

    private fun initClickEvent() {
        binding.btnLogin.setOnClickListener {
            startMain()
        }
    }

    private fun isEmailAndPasswordValid() {
        with(binding) {
            etId.addTextChangedListener {
                with(!etId.text.isNullOrEmpty()) {
                    isValidEmail = this
                    setLoginBtnEnable()
                    etId.isSelected = this
                }
            }

            etPassword.addTextChangedListener {
                with(!etPassword.text.isNullOrEmpty()) {
                    isValidPassword = this
                    setLoginBtnEnable()
                    etPassword.isSelected = this
                }
            }
        }
    }

    private fun setLoginBtnEnable() {
        binding.btnLogin.isEnabled = isValidEmail && isValidPassword
    }

    private fun startMain() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
