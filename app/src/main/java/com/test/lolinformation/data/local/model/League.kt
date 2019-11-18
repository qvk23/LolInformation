package com.test.lolinformation.data.local.model

import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("live_supported")
    val liveSupported: Boolean,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("series")
    val series: List<Sery>,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("url")
    val url: String
)
