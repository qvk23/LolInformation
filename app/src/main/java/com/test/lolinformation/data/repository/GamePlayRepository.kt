package com.test.lolinformation.data.repository

import com.test.lolinformation.data.local.model.Champion
import com.test.lolinformation.data.local.model.Item
import com.test.lolinformation.data.remote.response.ChampionListResponse
import com.test.lolinformation.data.remote.response.ItemListResponse

interface GamePlayRepository {
    suspend fun getChampions(page: Int, perPage: Int): ChampionListResponse

    suspend fun getItems(page: Int, perPage: Int): ItemListResponse

    suspend fun getChampionsLocal(): List<Champion>

    suspend fun insertChampions(champions: List<Champion>)

    suspend fun getItemsLocal(): List<Item>

    suspend fun insertItems(items: List<Item>)
}
