package org.mascota.user.ui.view.signup

import android.os.Bundle
import org.mascota.core.base.BindingActivity
import org.mascota.core.util.extension.replace
import org.mascota.user.R
import org.mascota.user.databinding.ActivitySignUpBinding

class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    private val signUpStartFragment: SignUpStartFragment by lazy { SignUpStartFragment() }
    private val signUpEndFragment: SignUpEndFragment by lazy { SignUpEndFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceSignUpStart()
        initClickEvent()
    }

    private fun initClickEvent() {
        binding.btnSignup.setOnClickListener {
            replaceSignUpEnd()
        }
    }

    private fun replaceSignUpStart() {
        replace(R.id.container_signup, signUpStartFragment)
    }

    private fun replaceSignUpEnd() {
        replace(R.id.container_signup, signUpEndFragment)
    }
}
