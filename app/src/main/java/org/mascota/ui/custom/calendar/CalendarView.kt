package org.mascota.ui.custom.calendar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.ViewCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import org.mascota.mascota.R
import org.mascota.mascota.databinding.ItemDateBinding
import org.mascota.mascota.databinding.LayoutCalendarTopBinding
import java.util.*

class CalendarView(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {
    private val calendarTopView
        get() = createCalendarTopView()

    private lateinit var layoutCalendarTopBinding: LayoutCalendarTopBinding

    private val nowCalendar = Calendar.getInstance(Locale.KOREA)
    private var dateItemGetter: (() -> List<Boolean>)? = null
    private var calendarGetter: (() -> Calendar)? = null

    private val dateItems = (1..42).map { _ ->
        ItemDateBinding.inflate(LayoutInflater.from(context), null, false).apply {
            root.id = ViewCompat.generateViewId()
        }
    }

    fun setCalendarGetter(listener: () -> Calendar) {
        calendarGetter = listener
    }

    fun setDateItemGetter(listener: () -> List<Boolean>) {
        dateItemGetter = listener
    }

    private val outerLinearLayout = LinearLayout(context).apply {
        id = ViewCompat.generateViewId()
        orientation = LinearLayout.VERTICAL
        weightSum = 6f

        layoutParams = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    private val innerLinearLayouts = (1..6).map {
        LinearLayout(context).apply {
            id = ViewCompat.generateViewId()
            orientation = LinearLayout.HORIZONTAL
            weightSum = 7f

            layoutParams = LinearLayout.LayoutParams(
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
        var pos = 0
        var index = 31
        val compCalendar = Calendar.getInstance(Locale.KOREA)
        compCalendar.set(Calendar.DAY_OF_MONTH, 1)
        //val dateItem = dateItemGetter?.invoke()
        //val compCalendar = calendarGetter?.invoke()?.clone() as Calendar
        //val curMonth = compCalendar.get(Calendar.MONTH)


        //if (dateItem != null) {
        //index = dateItem.size
        //}

//        compCalendar.set(Calendar.DAY_OF_MONTH, 1)
//        if (compCalendar.get(Calendar.DAY_OF_WEEK) == 1)
//            compCalendar.add(Calendar.DAY_OF_MONTH, -6)
//        else
//            compCalendar.add(Calendar.DAY_OF_MONTH, 2 - compCalendar.get(Calendar.DAY_OF_WEEK))

        innerLinearLayouts.forEach {
            it.removeAllViews()
        }
        outerLinearLayout.removeAllViews()

        layoutCalendarTopBinding.tvMonth.text = "10월"
        repeat(6) { row ->
            val innerLinearLayout = innerLinearLayouts[row]

            outerLinearLayout.addView(innerLinearLayout)

            repeat(7) { column ->
                val idx = row * 7 + column
                val item = dateItems[idx]

                item.tvDay.text = compCalendar.get(Calendar.DAY_OF_MONTH).toString()
                if (row == 0)
                    item.line.isVisible = false
                compCalendar.add(Calendar.DAY_OF_MONTH, 1)
                innerLinearLayout.addView(
                    item.root, LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f
                    )
                )
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
