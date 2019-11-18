package com.test.lolinformation.data.local.model

import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("hometown")
    val hometown: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("slug")
    val slug: String
)
