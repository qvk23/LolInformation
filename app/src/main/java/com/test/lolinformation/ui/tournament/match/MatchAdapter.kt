package com.test.lolinformation.ui.tournament.match

import androidx.recyclerview.widget.DiffUtil
import com.test.lolinformation.R
import com.test.lolinformation.data.local.model.Match
import com.test.lolinformation.databinding.ItemMatchBinding
import com.test.lolinformation.ui.base.BaseRecyclerAdapter
import com.test.lolinformation.utils.loadImage

class MatchAdapter : BaseRecyclerAdapter<Match, ItemMatchBinding>(DiffUtilCallBack()) {

    override val layoutId: Int = R.layout.item_match

    override fun bindView(binding: ItemMatchBinding, item: Match, position: Int) {
        super.bindView(binding, item, position)
        val teamLeft = item.opponents.get(FIRST).opponent
        val teamRight = item.opponents.get(SECOND).opponent
        binding.run {
            if (item.winnerId == teamLeft.id) {
                textScoreLeft.text = item.results.get(FIRST).score.toString()
                textScoreRight.text = item.results.get(SECOND).score.toString()
            } else {
                textScoreLeft.text = item.results.get(SECOND).score.toString()
                textScoreRight.text = item.results.get(FIRST).score.toString()
            }
            textTeamLeft.text = teamLeft.name
            textTeamRight.text = teamRight.name
            imageTeamLeft.loadImage(teamLeft.imageUrl)
            imageTeamRight.loadImage(teamRight.imageUrl)
        }
    }
    class DiffUtilCallBack : DiffUtil.ItemCallback<Match>() {
        override fun areItemsTheSame(oldItem: Match, newItem: Match) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Match, newItem: Match) = oldItem == newItem
    }
    companion object {
        const val FIRST = 0
        const val SECOND = 1
    }
}
