package com.test.lolinformation.data.model

import com.google.gson.annotations.SerializedName

data class Tournament(
    @SerializedName("begin_at")
    val beginAt: String,
    @SerializedName("end_at")
    val endAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("league")
    val league: League,
    @SerializedName("league_id")
    val leagueId: Int,
    @SerializedName("matches")
    val matches: List<Match>,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("prizepool")
    val prizePool: String,
    @SerializedName("serie")
    val serie: Sery,
    @SerializedName("serie_id")
    val serieId: Int,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("teams")
    val teams: List<Team>,
    @SerializedName("winner_id")
    val winnerId: Int,
    @SerializedName("winner_type")
    val winnerType: String
)
