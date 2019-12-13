package com.test.lolinformation.ui.tournament.team

import androidx.recyclerview.widget.DiffUtil
import com.test.lolinformation.R
import com.test.lolinformation.data.local.model.Team
import com.test.lolinformation.databinding.ItemTeamBinding
import com.test.lolinformation.ui.base.BaseRecyclerAdapter

class TeamAdapter(private val onItemClick: (Team) -> Unit) : BaseRecyclerAdapter<Team, ItemTeamBinding>(DiffUtilCallBack()) {
    override val layoutId: Int = R.layout.item_team
    override fun bindFirstTime(binding: ItemTeamBinding) {
        binding.layoutItemTeam.setOnClickListener {
            binding.item?.let(onItemClick)
        }
    }
    class DiffUtilCallBack : DiffUtil.ItemCallback<Team>() {
        override fun areItemsTheSame(oldItem: Team, newItem: Team) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Team, newItem: Team) = oldItem == newItem
    }
}
