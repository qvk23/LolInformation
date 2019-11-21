package com.test.lolinformation.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.test.lolinformation.data.local.model.Match

@Dao
interface MatchDao {
    @Query("SELECT * FROM `match`")
    suspend fun getMatchesList(): List<Match>

    @Insert
    suspend fun insertMatches(list: List<Match>)
}
