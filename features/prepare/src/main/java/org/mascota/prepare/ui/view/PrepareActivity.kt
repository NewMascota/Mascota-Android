package org.mascota.prepare.ui.view

import android.os.Bundle
import org.mascota.core.base.BindingActivity
import org.mascota.prepare.R
import org.mascota.prepare.databinding.ActivityPrepareBinding

class PrepareActivity : BindingActivity<ActivityPrepareBinding>(R.layout.activity_prepare) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun initClickEvent() {
        with(binding) {
            ibHome.setOnClickListener {

            }

            clSkip.setOnClickListener {

            }
        }
    }
}