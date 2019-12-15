package com.test.lolinformation.ui.gameplay.champion

import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import com.test.lolinformation.R
import com.test.lolinformation.data.local.model.Champion
import com.test.lolinformation.databinding.ItemChampionBinding
import com.test.lolinformation.ui.base.BaseRecyclerAdapter
import java.util.*

class ChampionAdapter(private val onItemClick: (Champion) -> Unit) :
    BaseRecyclerAdapter<Champion, ItemChampionBinding>(DiffUtilCallBack()), Filterable {

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

    override fun getFilter(): Filter {
        return itemFilter
    }

    private val itemFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList = listFull.filter {
                it.name.toLowerCase(Locale.getDefault()).contains(
                    constraint.toString().toLowerCase(Locale.getDefault()).trim()
                )
            }
            return FilterResults().also { it.values = filteredList }
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            submitList(results?.values as MutableList<Champion>)
        }
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<Champion>() {
        override fun areItemsTheSame(oldItem: Champion, newItem: Champion) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Champion, newItem: Champion) = oldItem == newItem
    }
}
