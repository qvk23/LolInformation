package com.test.lolinformation.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.lolinformation.data.local.model.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM  item ORDER BY item.id DESC LIMIT :pageSize OFFSET :page ")
    suspend fun getItemList(page: Int, pageSize: Int): List<Item>

    @Query("SELECT * FROM item WHERE item.id = :id ")
    suspend fun getItem(id: Int): Item

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(list: List<Item>)
}
