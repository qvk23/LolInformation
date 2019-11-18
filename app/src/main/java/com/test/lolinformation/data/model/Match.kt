package com.test.lolinformation.data.model

import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("begin_at")
    val beginAt: String,
    @SerializedName("detailed_stats")
    val detailedStats: Boolean,
    @SerializedName("draw")
    val draw: Boolean,
    @SerializedName("end_at")
    val endAt: String,
    @SerializedName("forfeit")
    val forfeit: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("live_url")
    val liveUrl: String,
    @SerializedName("match_type")
    val matchType: String,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("number_of_games")
    val numberOfGames: Int,
    @SerializedName("scheduled_at")
    val scheduledAt: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("tournament_id")
    val tournamentId: Int,
    @SerializedName("winner_id")
    val winnerId: Int
)
