package org.mascota.ui.view.custom.calendar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.ViewCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import java.util.Calendar
import org.mascota.calendar.R
import org.mascota.calendar.databinding.ItemDateBinding
import org.mascota.calendar.databinding.LayoutCalendarTopBinding

class CalendarView(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {
    private val calendarTopView
        get() = createCalendarTopView()

    private lateinit var layoutCalendarTopBinding: LayoutCalendarTopBinding

    // private var dateItemGetter: (() -> List<Pair<Boolean, Boolean>>)? = null
    private var calendarGetter: (() -> Calendar)? = null

    private val dateItems = (1..42).map { _ ->
        ItemDateBinding.inflate(LayoutInflater.from(context), null, false).apply {
            root.id = ViewCompat.generateViewId()
        }
    }

    fun setCalendarGetter(listener: () -> Calendar) {
        calendarGetter = listener
    }

    //    fun setDateItemGetter(listener: () -> List<Pair<Boolean, Boolean>>) {
    //        dateItemGetter = listener
    //    }

    private val outerLinearLayout = LinearLayout(context).apply {
        id = ViewCompat.generateViewId()
        orientation = VERTICAL
        weightSum = 6f

        layoutParams = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    private val innerLinearLayouts = (1..6).map {
        LinearLayout(context).apply {
            id = ViewCompat.generateViewId()
            orientation = HORIZONTAL
            weightSum = 7f

            layoutParams = LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            )
        }
    }

    init {
        orientation = VERTICAL
        addView(calendarTopView)
        addView(outerLinearLayout)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        updateUIWithDate()
    }

    private fun updateUIWithDate() {
        // val dateItem = dateItemGetter?.invoke()
        val compCalendar = requireNotNull(calendarGetter?.invoke())
        val curMonth = compCalendar.get(Calendar.MONTH)

        //        if (dateItem != null) {
        //        index = dateItem.size
        //        }

        layoutCalendarTopBinding.tvMonth.text = "${curMonth + 1}월"
        compCalendar.set(Calendar.DAY_OF_WEEK, 1)

        innerLinearLayouts.forEach {
            it.removeAllViews()
        }
        outerLinearLayout.removeAllViews()

        run {
            repeat(6) { row ->
                val innerLinearLayout = innerLinearLayouts[row]
                outerLinearLayout.addView(innerLinearLayout)

                repeat(7) { column ->
                    val idx = row * 7 + column
                    val item = dateItems[idx]

                    if (row == 0)
                        item.line.isVisible = false

                    if (compCalendar.get(Calendar.MONTH) != curMonth)
                        item.clDay.isVisible = false
                    else
                        item.tvDay.text = compCalendar.get(Calendar.DAY_OF_MONTH).toString()

                    compCalendar.add(Calendar.DAY_OF_MONTH, 1)

                    innerLinearLayout.addView(
                        item.root, LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            1f
                        )
                    )
                }

                if (compCalendar.get(Calendar.MONTH) == curMonth + 1)
                    return@run
            }
        }
    }

    private fun createCalendarTopView(): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        layoutCalendarTopBinding =
            DataBindingUtil.inflate(inflater, R.layout.layout_calendar_top, this, false)

        return layoutCalendarTopBinding.root
    }
}
