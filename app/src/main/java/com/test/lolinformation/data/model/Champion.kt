package com.test.lolinformation.data.model

import com.google.gson.annotations.SerializedName

data class Champion(
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
    @SerializedName("attackspeedoffset")
    val attackSpeedOffset: Any,
    @SerializedName("attackspeedperlevel")
    val attackSpeedPerLevel: Double,
    @SerializedName("big_image_url")
    val bigImageUrl: String,
    @SerializedName("crit")
    val crit: Double,
    @SerializedName("critperlevel")
    val critPerLevel: Double,
    @SerializedName("hp")
    val hp: Double,
    @SerializedName("hpperlevel")
    val hpPerLevel: Double,
    @SerializedName("hpregen")
    val hpRegen: Double,
    @SerializedName("hpregenperlevel")
    val hpRegenPerLevel: Double,
    @SerializedName("id")
    val id: Int,
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
)
