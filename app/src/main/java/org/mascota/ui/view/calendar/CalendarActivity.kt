package org.mascota.ui.view.calendar

import android.os.Bundle
import org.mascota.mascota.R
import org.mascota.mascota.databinding.ActivityCalendarBinding
import org.mascota.ui.base.BindingActivity
import org.mascota.ui.view.calendar.adapter.YearAdapter

class CalendarActivity : BindingActivity<ActivityCalendarBinding>(R.layout.activity_calendar) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun initClickEvent() {
        with(binding) {
            clYear.setOnClickListener {
                ibMore.isSelected = !ibMore.isSelected
                isListVisible = ibMore.isSelected
            }
        }
    }

    private fun initAdapter() {
        val yearAdapter = YearAdapter()

        yearAdapter.setItemClickListener { }
    }
}
