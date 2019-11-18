package com.test.lolinformation.data.local.model

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("acronym")
    val acronym: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("players")
    val players: List<Player>,
    @SerializedName("slug")
    val slug: String
)
