package com.test.lolinformation.data.repository

import com.test.lolinformation.data.local.model.League
import com.test.lolinformation.data.local.model.Match
import com.test.lolinformation.data.local.model.Player
import com.test.lolinformation.data.local.model.Sery
import com.test.lolinformation.data.remote.response.MatchesListResponse
import com.test.lolinformation.data.remote.response.PlayerListResponse
import com.test.lolinformation.data.remote.response.TeamListResponse

interface MatchRepository {

    suspend fun getLeagueByName(name: List<String>): List<League>

    suspend fun getSeriesByLeague(leagueId: Int, year: Int): List<Sery>

    suspend fun getMatchBySerie(serieId: Int, page: Int, perPage: Int): MatchesListResponse

    suspend fun getTeamBySerie(serieId: Int, page: Int, perPage: Int): TeamListResponse

    suspend fun getPlayerBySerie(serieId: Int, page: Int, perPage: Int): PlayerListResponse

    suspend fun getPlayerByTeam(teamId: Int): List<Player>

    suspend fun getMatchLocal(): List<Match>

    suspend fun insertMatch(matches: List<Match>)
}
