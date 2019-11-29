package com.test.lolinformation.data.remote.api

import com.test.lolinformation.data.local.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(PATH_CHAMPION)
    suspend fun getChampions(
        @Query(QUERY_PAGE) page: Int,
        @Query(QUERY_PER_PAGE) perPage: Int
    ) : List<Champion>

    @GET(PATH_ITEM)
    suspend fun getItems(
        @Query(QUERY_PAGE) page: Int,
        @Query(QUERY_PER_PAGE) perPage: Int
    ): List<Item>

    @GET(PATH_LEAGUE)
    suspend fun getLeagueByName(
        @Query(QUERY_FILTER_NAME) name: List<String>
    ): List<League>

    @GET(PATH_SERIE)
    suspend fun getSeriesByLeague(
        @Query(QUERY_FILTER_LEAGUE_ID) leagueId: Int,
        @Query(QUERY_FILTER_YEAR) year: Int
    ): List<Sery>

    @GET(PATH_MATCH)
    suspend fun getMatchesBySerie(
        @Query(QUERY_FILTER_SERIE_ID) serieId: Int,
        @Query(QUERY_PAGE) page: Int,
        @Query(QUERY_PER_PAGE) perPage: Int
    ): List<Match>

    @GET(PATH_PLAYER_FOR_SERIE)
    suspend fun getPlayerBySerie(
        @Path(PATH_PARAM_SERIE_ID) id: Int,
        @Query(QUERY_PAGE) page: Int,
        @Query(QUERY_PER_PAGE) perPage: Int
    ) : List<Player>

    @GET(PATH_PLAYER)
    suspend fun getPlayerByTeam(
        @Query(QUERY_FILTER_TEAM_ID) teamId: Int
    ) : List<Player>

    @GET(PATH_TEAM)
    suspend fun getTeamBySerie(
        @Path(PATH_PARAM_SERIE_ID) id: Int,
        @Query(QUERY_PAGE) page: Int,
        @Query(QUERY_PER_PAGE) perPage: Int
    ) : List<Team>
}
