package org.mascota.user.ui.view.signup

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import org.mascota.core.base.BindingFragment
import org.mascota.user.R
import org.mascota.user.databinding.FragmentSignUpStartBinding
import org.mascota.user.ui.viewmodel.UserViewModel

@AndroidEntryPoint
class SignUpStartFragment :
    BindingFragment<FragmentSignUpStartBinding>(R.layout.fragment_sign_up_start) {
    private var isValidEmail = false
    private var isValidPassword = false
    private var isSame = false

    private val viewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isEmailAndPasswordValid()
        initClickEvent()
    }

    private fun isEmailAndPasswordValid() {
        with(binding) {
            etId.addTextChangedListener {
                checkIdValidation(false)
                etId.isSelected = !it.isNullOrEmpty()
                setSignUpBtnEnable()
            }

            etPassword.addTextChangedListener {
                with(etPassword.text.length >= 8) {
                    checkPasswordSame()
                    isPasswordAvailable = this
                    isValidPassword = this
                    tvCanPasswordUse.isSelected = this
                    tvCanPasswordUse.isVisible = !it.isNullOrEmpty()
                    etPassword.isSelected = !it.isNullOrEmpty()
                    setSignUpBtnEnable()
                }
            }

            etPasswordCheck.addTextChangedListener {
                checkPasswordSame()
                tvSamePassword.isVisible = !it.isNullOrEmpty()
                etPasswordCheck.isSelected = !it.isNullOrEmpty()
                setSignUpBtnEnable()
            }
        }
    }

    private fun checkPasswordSame() {
        with(binding) {
            with(etPassword.text.toString() == etPasswordCheck.text.toString()) {
                isSame = this
                isPasswordSame = this
                tvSamePassword.isSelected = this
            }
        }
    }

    private fun checkIdValidation(isValid: Boolean) {
        with(binding) {
            isIdAvailable = isValid
            isValidEmail = isValid
            tvCanIdUse.isSelected = isValid
            tvCanIdUse.isVisible = isValid
            setSignUpBtnEnable()
        }
    }

    private fun initClickEvent() {
        with(binding) {
            tvDoubleCheck.setOnClickListener {
                if (!etId.text.isNullOrEmpty()) {
                    checkIdValidation(true)
                    viewModel.setEmail(etId.text.toString())
                }
            }

            ibBack.setOnClickListener {
                requireActivity().finish()
            }
        }
    }

    private fun setSignUpBtnEnable() {
        viewModel.setBtnEnableEvent(isValidEmail && isValidPassword && isSame)
    }
}
