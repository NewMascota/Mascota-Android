package org.mascota.farewell.ui.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.mascota.core.util.ItemDiffCallback
import org.mascota.farewell.databinding.ItemHelpBinding
import org.mascota.farewell.databinding.LayoutFarewellMainTopBinding
import org.mascota.farewell.ui.view.main.model.DiaryModel
import org.mascota.farewell.ui.view.main.model.HelpModel

class FarewellMainAdapter(
    private val itemClickListener: ItemClickListener
) : ListAdapter<HelpModel, FarewellMainAdapter>(
    ItemDiffCallback<HelpModel>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old == new }
    )
) {
    fun interface ItemClickListener {
        fun onClick(place: PlaceModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)


        val binding = ItemPlaceSearchBinding.inflate(inflater, parent, false)
        return PlaceViewHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    class FarewellMainTopViewHolder(
        private val binding: LayoutFarewellMainTopBinding,
        private val itemClickListener: ItemClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(diary: DiaryModel) {

        }
    }

    class HelpViewHolder(
        private val binding: ItemHelpBinding,
        private val itemClickListener: ItemClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(help: HelpModel) {

        }
    }

    companion object {
        const val FAREWELL_MAIN_TOP = 0
        const val HELP_ITEM = 1
    }
}
