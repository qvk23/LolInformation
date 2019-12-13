package com.test.lolinformation.data.local.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
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
    val players: @RawValue List<Player>,
    @SerializedName("slug")
    val slug: String
) : Parcelable
