package com.test.lolinformation.ui.tournament.series

import androidx.recyclerview.widget.DiffUtil
import com.test.lolinformation.R
import com.test.lolinformation.data.local.model.Series
import com.test.lolinformation.databinding.ItemSeryBinding
import com.test.lolinformation.ui.base.BaseRecyclerAdapter

class SerieAdapter(private val onItemClick: (Series) -> Unit) :
    BaseRecyclerAdapter<Series, ItemSeryBinding>(DiffUtilCallBack()) {

    override val layoutId: Int = R.layout.item_sery

    override fun bindFirstTime(binding: ItemSeryBinding) {
        super.bindFirstTime(binding)
        binding.itemSerie.setOnClickListener {
            binding.item?.let { onItemClick(it) }
        }
    }
    class DiffUtilCallBack : DiffUtil.ItemCallback<Series>() {
        override fun areItemsTheSame(oldItem: Series, newItem: Series) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Series, newItem: Series) = oldItem == newItem
    }
}
