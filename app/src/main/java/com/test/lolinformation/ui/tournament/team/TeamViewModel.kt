package com.test.lolinformation.ui.tournament.team

import com.test.lolinformation.data.local.model.Team
import com.test.lolinformation.data.repository.MatchRepository
import com.test.lolinformation.ui.base.BaseLoadMoreViewModel

class TeamViewModel(
    private val matchRepository: MatchRepository
) : BaseLoadMoreViewModel<Team>() {

    override fun loadData(page: Int) {
    }
}
