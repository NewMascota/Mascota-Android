package org.mascota.calendar.ui.view

import android.os.Bundle
import java.util.Calendar
import org.mascota.calendar.R
import org.mascota.calendar.databinding.ActivityCalendarBinding
import org.mascota.calendar.ui.view.adapter.YearAdapter
import org.mascota.calendar.ui.view.adapter.YearAdapter.Companion.MORE
import org.mascota.core.base.BindingActivity
import org.mascota.ui.view.custom.adapter.CalendarViewPagerAdapter
import org.mascota.ui.view.custom.adapter.CalendarViewPagerAdapter.Companion.FIRST_POSITION

class CalendarActivity : BindingActivity<ActivityCalendarBinding>(R.layout.activity_calendar) {
    private val calendar = Calendar.getInstance()
    private var year = calendar.get(Calendar.YEAR)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
        initClickEvent()
        initAdapter()
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

        yearAdapter.data = listOf(
            year - 1,
            year + 1,
            MORE
        )

        with(binding) {
            yearAdapter.setItemClickListener {
                with(tvYear) {
                    if (it != MORE) {
                        text = "${it}년"
                        year = it

                        yearAdapter.data = listOf(
                            year - 1,
                            year + 1,
                            MORE
                        )
                    } else
                        text = getString(R.string.more)
                }

                ibMore.isSelected = !ibMore.isSelected
                isListVisible = false
            }

            rvYear.adapter = yearAdapter

            with(vpCalendar) {
                adapter = CalendarViewPagerAdapter()
                setCurrentItem(FIRST_POSITION, false)
            }
        }
    }

    private fun initUi() {
        binding.tvYear.text = "${year}년"
    }
}
