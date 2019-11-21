package com.test.lolinformation.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "item")
data class Item(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false) val id: Int,
    @SerializedName("flat_armor_mod")
    val flatArmorMod: Int,
    @SerializedName("flat_crit_chance_mod")
    val flatCritChanceMod: Int,
    @SerializedName("flat_hp_pool_mod")
    val flatHpPoolMod: Int,
    @SerializedName("flat_hp_regen_mod")
    val flatHpRegenMod: Int,
    @SerializedName("flat_magic_damage_mod")
    val flatMagicDamageMod: Int,
    @SerializedName("flat_movement_speed_mod")
    val flatMovementSpeedMod: Int,
    @SerializedName("flat_mp_pool_mod")
    val flatMpPoolMod: Int,
    @SerializedName("flat_mp_regen_mod")
    val flatMpRegenMod: Int,
    @SerializedName("flat_physical_damage_mod")
    val flatPhysicalDamageMod: Int,
    @SerializedName("flat_spell_block_mod")
    val flatSpellBlockMod: Double?,
    @SerializedName("gold_base")
    val goldBase: Int?,
    @SerializedName("gold_purchasable")
    val goldPurchasable: Boolean,
    @SerializedName("gold_sell")
    val goldSell: Int?,
    @SerializedName("gold_total")
    val goldTotal: Int?,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("is_trinket")
    val isTrinket: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("percent_attack_speed_mod")
    val percentAttackSpeedMod: Int,
    @SerializedName("percent_life_steal_mod")
    val percentLifeStealMod: Int,
    @SerializedName("percent_movement_speed_mod")
    val percentMovementSpeedMod: Int
)
