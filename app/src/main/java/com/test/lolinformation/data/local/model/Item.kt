package com.test.lolinformation.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "item")
data class Item(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false) val id: Int,
    @SerializedName("gold_total")
    val goldTotal: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("name")
    val name: String
)
