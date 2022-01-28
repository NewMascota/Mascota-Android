package org.mascota.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.mascota.R
import org.mascota.core.util.extension.getString
import org.mascota.databinding.ItemYearBinding

class YearAdapter(
    private var itemClickListener: ((Int) -> Unit)? = null
) : RecyclerView.Adapter<YearAdapter.YearViewHolder>() {
    private val _data = mutableListOf<Int>()
    var data: List<Int> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    fun setItemClickListener(listener: (Int) -> Unit) {
        itemClickListener = listener
    }

    override fun getItemCount(): Int = _data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YearViewHolder {
        val binding: ItemYearBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_year, parent, false
        )
        return YearViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: YearViewHolder,
        position: Int
    ) {
        holder.bind(data[position], itemClickListener)
    }

    class YearViewHolder(
        private val binding: ItemYearBinding
    ) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(data: Int, itemClickListener: ((Int) -> Unit)? = null) {
            with(binding.tvYear) {
                text = if (data != MORE)
                    "${data}년"
                else
                    getString(R.string.more)
            }

            binding.clYear.setOnClickListener {
                itemClickListener?.invoke(data)
            }
        }
    }

    companion object {
        const val MORE = -1
    }
}
