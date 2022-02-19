package org.mascota.ui.view.custom.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.Calendar
import java.util.Locale
import org.mascota.ui.view.custom.calendar.CalendarView

class CalendarViewPagerAdapter :
    RecyclerView.Adapter<CalendarViewPagerAdapter.CalendarViewHolder>() {
    override fun getItemCount(): Int = MAX_ITEM_COUNT

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        return CalendarViewHolder(CalendarView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        })
    }

    override fun onBindViewHolder(
        holder: CalendarViewHolder,
        position: Int
    ) {
        holder.bind(position)
    }

    class CalendarViewHolder(private val view: CalendarView) : RecyclerView.ViewHolder(view) {
        fun bind(position: Int) {

            view.setCalendarGetter {
                return@setCalendarGetter Calendar.getInstance(Locale.KOREA).apply {
                    set(Calendar.DAY_OF_MONTH, 1)
                    add(Calendar.MONTH, position - FIRST_POSITION)
                }
            }
        }
    }

    companion object {
        const val MAX_ITEM_COUNT = Int.MAX_VALUE
        const val FIRST_POSITION = MAX_ITEM_COUNT / 2
    }
}
