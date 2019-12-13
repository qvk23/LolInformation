package com.test.lolinformation.ui.tournament.detailteam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.lolinformation.data.local.model.Player
import com.test.lolinformation.data.local.model.Team
import com.test.lolinformation.ui.base.BaseViewModel

class DetailTeamViewModel : BaseViewModel() {
    private val _team = MutableLiveData<Team>()
    val team: LiveData<Team> get() = _team
    private val _listPlayers = MutableLiveData<ArrayList<Player>>()
    val listPlayer: LiveData<ArrayList<Player>> get() = _listPlayers
    fun setTeam(team: Team) {
        _team.value = team
    }
    fun setPlayers(players: ArrayList<Player>) {
        _listPlayers.value = players
    }
}
