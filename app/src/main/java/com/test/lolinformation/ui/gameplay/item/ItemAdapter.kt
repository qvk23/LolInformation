package com.test.lolinformation.ui.gameplay.item

import androidx.recyclerview.widget.DiffUtil
import com.test.lolinformation.R
import com.test.lolinformation.data.local.model.Item
import com.test.lolinformation.databinding.ItemEquipmentBinding
import com.test.lolinformation.ui.base.BaseRecyclerAdapter

class ItemAdapter : BaseRecyclerAdapter<Item, ItemEquipmentBinding>(DiffUtilCallBack()) {

    override val layoutId: Int = R.layout.item_equipment

    class DiffUtilCallBack : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
    }
}
