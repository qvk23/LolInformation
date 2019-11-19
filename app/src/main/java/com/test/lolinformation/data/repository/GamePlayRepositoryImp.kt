package com.test.lolinformation.data.repository

import com.test.lolinformation.data.local.dao.ChampionDao
import com.test.lolinformation.data.local.dao.ItemDao
import com.test.lolinformation.data.local.model.Champion
import com.test.lolinformation.data.local.model.Item
import com.test.lolinformation.data.remote.api.ApiService
import com.test.lolinformation.data.remote.response.ChampionListResponse
import com.test.lolinformation.data.remote.response.ItemListResponse

class GamePlayRepositoryImp(
    private val apiService: ApiService,
    private val championDao: ChampionDao,
    private val itemDao: ItemDao
) : GamePlayRepository {

    override suspend fun getChampions(page: Int, perPage: Int): ChampionListResponse =
        apiService.getChampions(page, perPage)

    override suspend fun getItems(page: Int, perPage: Int): ItemListResponse =
        apiService.getItems(page, perPage)

    override suspend fun getChampionsLocal(): List<Champion> = championDao.getChampionList()

    override suspend fun insertChampions(champions: List<Champion>) =
        championDao.insertChampion(champions)

    override suspend fun getItemsLocal(): List<Item> = itemDao.getItemList()

    override suspend fun insertItems(items: List<Item>) = itemDao.insertItems(items)

}
