package com.test.lolinformation.data.repository

import com.test.lolinformation.data.local.dao.MatchDao
import com.test.lolinformation.data.local.model.League
import com.test.lolinformation.data.local.model.Match
import com.test.lolinformation.data.local.model.Player
import com.test.lolinformation.data.local.model.Sery
import com.test.lolinformation.data.remote.api.ApiService
import com.test.lolinformation.data.remote.response.MatchesListResponse
import com.test.lolinformation.data.remote.response.PlayerListResponse
import com.test.lolinformation.data.remote.response.TeamListResponse

class MatchRepositoryImp(
    private val apiService: ApiService,
    private val matchDao: MatchDao
) : MatchRepository {

    override suspend fun getLeagueByName(name: List<String>): List<League> =
        apiService.getLeagueByName(name)

    override suspend fun getSeriesByLeague(leagueId: Int, year: Int): List<Sery> =
        apiService.getSeriesByLeague(leagueId, year)

    override suspend fun getMatchBySerie(
        serieId: Int,
        page: Int,
        perPage: Int
    ): MatchesListResponse = apiService.getMatchesBySerie(serieId, page, perPage)

    override suspend fun getTeamBySerie(serieId: Int, page: Int, perPage: Int): TeamListResponse =
        apiService.getTeamBySerie(serieId, page, perPage)


    override suspend fun getPlayerBySerie(
        serieId: Int,
        page: Int,
        perPage: Int
    ): PlayerListResponse = apiService.getPlayerBySerie(serieId, page, perPage)

    override suspend fun getPlayerByTeam(teamId: Int): List<Player> =
        apiService.getPlayerByTeam(teamId)

    override suspend fun getMatchLocal(): List<Match> = matchDao.getMatchesList()

    override suspend fun insertMatch(matches: List<Match>) = matchDao.insertMatches(matches)

}
