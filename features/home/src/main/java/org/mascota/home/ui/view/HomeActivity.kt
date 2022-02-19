package org.mascota.home.ui.view

import android.content.Intent
import android.os.Bundle
import org.mascota.calendar.ui.view.CalendarActivity
import org.mascota.core.base.BindingActivity
import org.mascota.home.R
import org.mascota.home.databinding.ActivityHomeBinding

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initClickEvent()
    }

    private fun initClickEvent() {
        binding.ibCalendar.setOnClickListener {
            startCalendar()
        }
    }

    private fun startCalendar() {
        startActivity(Intent(this, CalendarActivity::class.java))
    }
}
