package com.test.lolinformation.data.repository

import com.test.lolinformation.data.local.model.Champion
import com.test.lolinformation.data.local.model.Item

interface GamePlayRepository {
    suspend fun getChampions(page: Int, perPage: Int): List<Champion>

    suspend fun getItems(page: Int, perPage: Int): List<Item>

    suspend fun getChampionsLocal(page: Int, perPage: Int): List<Champion>

    suspend fun insertChampions(champions: List<Champion>)

    suspend fun getItemsLocal(page: Int, perPage: Int): List<Item>

    suspend fun insertItems(items: List<Item>)
}
