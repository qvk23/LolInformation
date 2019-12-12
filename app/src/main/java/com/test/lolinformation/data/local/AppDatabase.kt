package com.test.lolinformation.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.lolinformation.data.local.dao.ChampionDao
import com.test.lolinformation.data.local.dao.ItemDao
import com.test.lolinformation.data.local.model.Champion
import com.test.lolinformation.data.local.model.Item

@Database(
    entities = [Champion::class, Item::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun championDao(): ChampionDao
    abstract fun itemDao(): ItemDao

    companion object {
        val DATABASE_NAME = "DATABASE_NAME"
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DATABASE_NAME
            ).allowMainThreadQueries().build().also { INSTANCE = it }
        }
    }
}
