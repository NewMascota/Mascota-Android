package org.mascota.ui.view

import android.os.Bundle
import org.mascota.R
import org.mascota.core.base.BindingActivity
import org.mascota.databinding.ActivityCalendarBinding
import org.mascota.ui.view.adapter.YearAdapter
import org.mascota.ui.view.adapter.YearAdapter.Companion.MORE
import java.util.Calendar

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

        yearAdapter.setItemClickListener {
            with(binding) {
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
        }

        binding.rvYear.adapter = yearAdapter
    }

    private fun initUi() {
        binding.tvYear.text = "${year}년"
    }
}