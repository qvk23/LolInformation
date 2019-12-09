package com.test.lolinformation.ui.tournament.series

import androidx.recyclerview.widget.DiffUtil
import com.test.lolinformation.R
import com.test.lolinformation.data.local.model.Sery
import com.test.lolinformation.databinding.ItemSeryBinding
import com.test.lolinformation.ui.base.BaseRecyclerAdapter

class SerieAdapter : BaseRecyclerAdapter<Sery, ItemSeryBinding>(DiffUtilCallBack()) {

    override val layoutId: Int = R.layout.item_sery

    class DiffUtilCallBack : DiffUtil.ItemCallback<Sery>() {
        override fun areItemsTheSame(oldItem: Sery, newItem: Sery) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Sery, newItem: Sery) = oldItem == newItem
    }
}
