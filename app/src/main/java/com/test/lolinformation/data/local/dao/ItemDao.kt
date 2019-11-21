package com.test.lolinformation.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.test.lolinformation.data.local.model.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM  item")
    suspend fun getItemList(): List<Item>

    @Query("SELECT * FROM item WHERE item.id = :id ")
    suspend fun getItem(id: Int): Item

    @Insert
    suspend fun insertItems(list: List<Item>)
}
