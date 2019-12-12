package com.test.lolinformation.ui.tournament.team

import androidx.lifecycle.viewModelScope
import com.test.lolinformation.data.local.model.Team
import com.test.lolinformation.data.remote.api.DEFAULT_ITEM_PER_PAGE
import com.test.lolinformation.data.repository.MatchRepository
import com.test.lolinformation.ui.base.BaseLoadMoreViewModel
import kotlinx.coroutines.launch

class TeamViewModel(private val matchRepository: MatchRepository) : BaseLoadMoreViewModel<Team>() {
    private var serieId = 0
    fun setSerieId(id: Int) {
        serieId = id
    }
    override fun loadData(page: Int) {
        viewModelScope.launch {
            try {
                onLoadSuccess(page, matchRepository.getTeamBySerie(serieId, page, DEFAULT_ITEM_PER_PAGE))
            } catch (e : Exception) {
                onLoadFaild(e)
            }
        }
    }
}
