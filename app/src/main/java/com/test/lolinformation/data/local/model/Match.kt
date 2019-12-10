package com.test.lolinformation.data.local.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("id")
    val id: Int,
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
    @SerializedName("opponents")
    val opponents: List<Opponent>,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("scheduled_at")
    val scheduledAt: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("winner_id")
    val winnerId: Int
) {
    data class Result(
        @SerializedName("score")
        val score: Int,
        @SerializedName("team_id")
        val teamId: Int
    )
    data class Opponent(
        @SerializedName("opponent")
        val opponent: Opponent,
        @SerializedName("type")
        val type: String
    ) {
        data class Opponent(
            @SerializedName("acronym")
            val acronym: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("image_url")
            val imageUrl: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("slug")
            val slug: String
        )
    }
}
