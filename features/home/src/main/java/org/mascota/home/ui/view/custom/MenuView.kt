package org.mascota.home.ui.view.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.ViewCompat
import org.mascota.core.util.extension.getString
import org.mascota.home.R
import org.mascota.home.databinding.ItemHomeBinding

class MenuView(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {
    private val menuItems = (1..5).map {
        ItemHomeBinding.inflate(LayoutInflater.from(context), null, false).apply {
            root.id = ViewCompat.generateViewId()
        }
    }

    init {
        orientation = VERTICAL
        weightSum = 5f
        initView()
        for (i in 0..4) {
            addView(menuItems[i].root.apply {
                layoutParams = LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    0,
                    1f
                )
            })
        }
    }

    private fun initView() {
        with(menuItems[READY]) {
            ivIcon.setBackgroundResource(R.drawable.selector_ready)
            tvTitle.text = getString(R.string.ready)
            tvContent.text = getString(R.string.ready_explain)
            isTopLineNotVisible = true
        }

        with(menuItems[WRITE]) {
            ivIcon.setBackgroundResource(R.drawable.selector_write)
            tvTitle.text = getString(R.string.write)
            tvContent.text = getString(R.string.write_explain)
        }

        with(menuItems[MEMORY]) {
            ivIcon.setBackgroundResource(R.drawable.selector_memory)
            tvTitle.text = getString(R.string.memory)
            tvContent.text = getString(R.string.memory_explain)
        }

        with(menuItems[FAREWELL]) {
            ivIcon.setBackgroundResource(R.drawable.selector_farewell)
            tvTitle.text = getString(R.string.farewell)
            tvContent.text = getString(R.string.farewell_explain)
        }

        with(menuItems[ACCEPT]) {
            ivIcon.setBackgroundResource(R.drawable.selector_accept)
            tvTitle.text = getString(R.string.accept)
            tvContent.text = getString(R.string.accept_explain)
            isBottomLineNotVisible = true
        }
    }

    private fun setMenuClickEvent() {
        with(menuItems[READY]) {
            clItem.setOnClickListener {

            }
        }

        with(menuItems[WRITE]) {
            clItem.setOnClickListener {

            }
        }

        with(menuItems[MEMORY]) {
            clItem.setOnClickListener {

            }
        }

        with(menuItems[FAREWELL]) {
            clItem.setOnClickListener {

            }
        }

        with(menuItems[ACCEPT]) {
            clItem.setOnClickListener {

            }
        }
    }

    companion object {
        const val READY = 0
        const val WRITE = 1
        const val MEMORY = 2
        const val FAREWELL = 3
        const val ACCEPT = 4
    }
}
