package org.mascota.ui.view.calendar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.mascota.mascota.R
import org.mascota.mascota.databinding.ItemYearBinding

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
        holder.bind(data[position])
    }

    class YearViewHolder(
        private val binding: ItemYearBinding
    ) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(data: Int) {
            binding.tvYear.text = "{$data}년"
        }
    }
}
