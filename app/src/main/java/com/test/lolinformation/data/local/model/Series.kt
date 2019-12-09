package com.test.lolinformation.data.local.model

import com.google.gson.annotations.SerializedName

data class Series(
    @SerializedName("begin_at")
    val beginAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("end_at")
    val endAt: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("league")
    val league: League,
    @SerializedName("league_id")
    val leagueId: Int,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("prizepool")
    val prizePool: String,
    @SerializedName("season")
    val season: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("tournaments")
    val tournaments: List<Tournament>,
    @SerializedName("winner_id")
    val winnerId: Int,
    @SerializedName("winner_type")
    val winnerType: String,
    @SerializedName("year")
    val year: Int
)
