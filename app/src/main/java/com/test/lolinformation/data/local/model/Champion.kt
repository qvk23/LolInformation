package com.test.lolinformation.data.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "champion")
data class Champion(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false) val id: Int,
    @SerializedName("armor")
    val armor: Double,
    @SerializedName("armorperlevel")
    val armorPerLevel: Double,
    @SerializedName("attackdamage")
    val attackDamage: Double,
    @SerializedName("attackdamageperlevel")
    val attackDamagePerLevel: Double,
    @SerializedName("attackrange")
    val attackRange: Double,
    @SerializedName("big_image_url")
    val bigImageUrl: String,
    @SerializedName("hp")
    val hp: Double,
    @SerializedName("hpperlevel")
    val hpPerLevel: Double,
    @SerializedName("hpregen")
    val hpRegen: Double,
    @SerializedName("hpregenperlevel")
    val hpRegenPerLevel: Double,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("movespeed")
    val moveSpeed: Double,
    @SerializedName("mp")
    val mp: Double,
    @SerializedName("mpperlevel")
    val mpPerLevel: Double,
    @SerializedName("mpregen")
    val mpRegen: Double,
    @SerializedName("mpregenperlevel")
    val mpRegenPerLevel: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("spellblock")
    val spellBlock: Double,
    @SerializedName("spellblockperlevel")
    val spellBlockPerLevel: Double
) : Parcelable
