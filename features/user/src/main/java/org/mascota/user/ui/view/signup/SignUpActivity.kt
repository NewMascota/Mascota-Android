package org.mascota.user.ui.view.signup

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import org.mascota.core.base.BindingActivity
import org.mascota.core.util.extension.repeatOnStarted
import org.mascota.core.util.extension.replace
import org.mascota.home.ui.view.HomeActivity
import org.mascota.user.R
import org.mascota.user.databinding.ActivitySignUpBinding
import org.mascota.user.ui.viewmodel.UserViewModel

@AndroidEntryPoint
class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    private val viewModel: UserViewModel by viewModels()
    private val signUpStartFragment: SignUpStartFragment by lazy { SignUpStartFragment() }
    private val signUpEndFragment: SignUpEndFragment by lazy { SignUpEndFragment() }
    private var isSignUpEnd = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceSignUpStart()
        initClickEvent()
        observeBtnEvent()
    }

    private fun initClickEvent() {
        binding.btnSignup.setOnClickListener {
            when (isSignUpEnd) {
                true -> startMain()
                else -> replaceSignUpEnd()
            }
        }
    }

    private fun startMain() {
        startActivity(Intent(this, HomeActivity::class.java))
        finishAffinity()
    }

    private fun observeBtnEvent() {
        repeatOnStarted {
            viewModel.signUpBtnEnableEvent.collect {
                binding.btnSignup.isEnabled = it
            }
        }

        repeatOnStarted {
            viewModel.signUpBtnTextChangeEvent.collect {
                binding.isSignUpEnd = it
                isSignUpEnd = it
            }
        }
    }

    private fun replaceSignUpStart() {
        replace(R.id.container_signup, signUpStartFragment)
    }

    private fun replaceSignUpEnd() {
        replace(R.id.container_signup, signUpEndFragment)
    }
}
