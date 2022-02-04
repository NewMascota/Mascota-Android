package org.mascota.ui.custom.adapter

import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import org.mascota.ui.custom.calendar.CalendarView
import java.util.*

class CalendarViewPagerAdapter :
    RecyclerView.Adapter<CalendarViewPagerAdapter.CalendarViewHolder>() {
    //리스너 달기
    private val dateData = MutableLiveData<Boolean>()

    fun setDateData(data: Boolean) {
        dateData.value = data
    }

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

    inner class CalendarViewHolder(private val view: CalendarView) : RecyclerView.ViewHolder(view) {
        fun bind(position: Int) {

            view.setCalendarGetter {
                return@setCalendarGetter Calendar.getInstance(Locale.KOREA).apply {
                    set(Calendar.DAY_OF_MONTH, 1)
                    //add(Calendar.MONTH, position - FIRST_POSITION)
                }
            }
//            dateData.observe(lifecycleOwner) {
//                view.setDateItemGetter {
//                    return@setDateItemGetter it.data.calendar.date
//                }
//            }
        }
    }

    companion object {
        const val MAX_ITEM_COUNT = Int.MAX_VALUE
    }
}
