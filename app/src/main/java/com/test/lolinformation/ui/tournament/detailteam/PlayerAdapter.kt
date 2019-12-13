package com.test.lolinformation.ui.tournament.detailteam

import androidx.recyclerview.widget.DiffUtil
import com.test.lolinformation.R
import com.test.lolinformation.data.local.model.Player
import com.test.lolinformation.databinding.ItemPlayerBinding
import com.test.lolinformation.ui.base.BaseRecyclerAdapter

class PlayerAdapter : BaseRecyclerAdapter<Player, ItemPlayerBinding>(DiffUtilCallBack()) {

    override val layoutId: Int = R.layout.item_player

    class DiffUtilCallBack : DiffUtil.ItemCallback<Player>() {
        override fun areItemsTheSame(oldItem: Player, newItem: Player) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Player, newItem: Player) = oldItem == newItem
    }
}
