package com.test.lolinformation.ui.tournament.series

import androidx.lifecycle.viewModelScope
import com.test.lolinformation.data.local.model.Sery
import com.test.lolinformation.data.remote.api.LCK_LEAGUE_ID
import com.test.lolinformation.data.remote.api.YEAR
import com.test.lolinformation.data.repository.MatchRepository
import com.test.lolinformation.ui.base.BaseLoadMoreViewModel
import kotlinx.coroutines.launch

class SerieViewModel(private val matchRepository: MatchRepository) : BaseLoadMoreViewModel<Sery>() {

    private var leagueId : Int = 0
    fun setLeagueId(id: Int) {
        leagueId = id
    }
    override fun loadData(page: Int) {
        viewModelScope.launch {
            try {
                onLoadSuccess(page, matchRepository.getSeriesByLeague(leagueId, YEAR))
            } catch (e : Exception) {
                onLoadFaild(e)
            }
        }
    }
}
