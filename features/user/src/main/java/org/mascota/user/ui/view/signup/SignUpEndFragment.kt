package org.mascota.user.ui.view.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import org.mascota.core.base.BindingFragment
import org.mascota.user.R
import org.mascota.user.databinding.FragmentSignUpEndBinding
import org.mascota.user.ui.viewmodel.UserViewModel

@AndroidEntryPoint
class SignUpEndFragment : BindingFragment<FragmentSignUpEndBinding>(R.layout.fragment_sign_up_end) {
    private val viewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.tvId.text = viewModel.getEmail()
        viewModel.setBtnTextChangeEvent(true)
    }
}
