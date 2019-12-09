package com.test.lolinformation.data.repository

import com.test.lolinformation.data.local.model.*

interface MatchRepository {

    suspend fun getLeagueByName(name: List<String>): List<League>

    suspend fun getSeriesByLeague(leagueId: Int, year: Int): List<Series>

    suspend fun getMatchBySerie(serieId: Int, page: Int, perPage: Int): List<Match>

    suspend fun getTeamBySerie(serieId: Int, page: Int, perPage: Int): List<Team>

    suspend fun getPlayerBySerie(serieId: Int, page: Int, perPage: Int): List<Player>

    suspend fun getPlayerByTeam(teamId: Int): List<Player>

    suspend fun getMatchLocal(): List<Match>

    suspend fun insertMatch(matches: List<Match>)
}
