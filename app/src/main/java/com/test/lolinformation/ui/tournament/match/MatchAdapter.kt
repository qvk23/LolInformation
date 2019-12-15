package com.test.lolinformation.ui.tournament.match

import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import com.test.lolinformation.R
import com.test.lolinformation.data.local.model.Match
import com.test.lolinformation.databinding.ItemMatchBinding
import com.test.lolinformation.ui.base.BaseRecyclerAdapter
import com.test.lolinformation.utils.loadImage
import java.util.*
import kotlin.collections.ArrayList

class MatchAdapter : BaseRecyclerAdapter<Match, ItemMatchBinding>(DiffUtilCallBack()), Filterable {

    override val layoutId: Int = R.layout.item_match

    override fun bindView(binding: ItemMatchBinding, item: Match, position: Int) {
        super.bindView(binding, item, position)
        val teamLeft = item.opponents[FIRST].opponent
        val teamRight = item.opponents[SECOND].opponent
        binding.run {
            if (item.winnerId == teamLeft.id) {
                textScoreLeft.text = item.results[FIRST].score.toString()
                textScoreRight.text = item.results[SECOND].score.toString()
            } else {
                textScoreLeft.text = item.results[SECOND].score.toString()
                textScoreRight.text = item.results[FIRST].score.toString()
            }
            textTeamLeft.text = teamLeft.name
            textTeamRight.text = teamRight.name
            imageTeamLeft.loadImage(teamLeft.imageUrl)
            imageTeamRight.loadImage(teamRight.imageUrl)
        }
    }

    override fun getFilter(): Filter = itemFilter

    private val itemFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {

            val filteredList = listFull.filter {
                it.opponents[FIRST].opponent.name.toLowerCase(Locale.getDefault()).contains(
                    constraint.toString().toLowerCase(Locale.getDefault()).trim()
                )
                it.opponents[SECOND].opponent.name.toLowerCase(Locale.getDefault()).contains(
                    constraint.toString().toLowerCase(Locale.getDefault()).trim()
                )
            }
            return FilterResults().also { it.values = filteredList }
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            submitList(results?.values as MutableList<Match>?)
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
