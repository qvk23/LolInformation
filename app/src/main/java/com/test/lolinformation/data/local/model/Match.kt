package com.test.lolinformation.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "match")
data class Match(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false) val id: Int,
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
