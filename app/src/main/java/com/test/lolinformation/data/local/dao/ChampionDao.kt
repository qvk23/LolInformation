package com.test.lolinformation.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.lolinformation.data.local.model.Champion

@Dao
interface ChampionDao {
    @Query("SELECT * FROM  champion ORDER BY champion.id DESC LIMIT :pageSize OFFSET :page")
    suspend fun getChampionList(page: Int, pageSize: Int): List<Champion>

    @Query("SELECT * FROM champion WHERE champion.id = :id ")
    suspend fun getChampion(id: Int): Champion

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChampion(list: List<Champion>)
}
