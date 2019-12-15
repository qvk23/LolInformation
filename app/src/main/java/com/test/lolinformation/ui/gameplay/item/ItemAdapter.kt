package com.test.lolinformation.ui.gameplay.item

import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import com.test.lolinformation.R
import com.test.lolinformation.data.local.model.Item
import com.test.lolinformation.databinding.ItemEquipmentBinding
import com.test.lolinformation.ui.base.BaseRecyclerAdapter
import java.util.*
import kotlin.collections.ArrayList

class ItemAdapter : BaseRecyclerAdapter<Item, ItemEquipmentBinding>(DiffUtilCallBack()),
    Filterable {

    override val layoutId: Int = R.layout.item_equipment

    override fun getFilter(): Filter = itemFilter

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
            submitList(results?.values as MutableList<Item>)
        }
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
    }
}
