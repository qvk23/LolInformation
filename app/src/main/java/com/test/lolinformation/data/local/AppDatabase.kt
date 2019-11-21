package com.test.lolinformation.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.lolinformation.data.local.dao.ChampionDao
import com.test.lolinformation.data.local.dao.ItemDao
import com.test.lolinformation.data.local.dao.MatchDao
import com.test.lolinformation.data.local.model.Champion
import com.test.lolinformation.data.local.model.Item
import com.test.lolinformation.data.local.model.Match

@Database(
    entities = [Champion::class, Item::class, Match::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun championDao(): ChampionDao
    abstract fun itemDao(): ItemDao
    abstract fun matchDao(): MatchDao
}
