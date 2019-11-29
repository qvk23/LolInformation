package com.test.lolinformation.ui.gameplay.champion

import androidx.recyclerview.widget.DiffUtil
import com.test.lolinformation.R
import com.test.lolinformation.data.local.model.Champion
import com.test.lolinformation.databinding.ItemChampionBinding
import com.test.lolinformation.ui.base.BaseRecyclerAdapter

class ChampionAdapter(private val onItemClick: (Champion) -> Unit) :
    BaseRecyclerAdapter<Champion, ItemChampionBinding>(DiffUtilCallBack()) {

    override val layoutId: Int = R.layout.item_champion

    override fun bindFirstTime(binding: ItemChampionBinding) {
        binding.apply {
            itemChampion.setOnClickListener {
                item?.let {
                    onItemClick(it)
                }
            }
        }
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<Champion>() {
        override fun areItemsTheSame(oldItem: Champion, newItem: Champion) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Champion, newItem: Champion) = oldItem == newItem
    }
}
