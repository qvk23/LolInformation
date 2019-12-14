package com.test.lolinformation.data.repository

import com.test.lolinformation.data.local.dao.ChampionDao
import com.test.lolinformation.data.local.dao.ItemDao
import com.test.lolinformation.data.local.model.Champion
import com.test.lolinformation.data.local.model.Item
import com.test.lolinformation.data.remote.api.ApiService

class GamePlayRepositoryImp(
    private val apiService: ApiService,
    private val championDao: ChampionDao,
    private val itemDao: ItemDao
) : GamePlayRepository {

    override suspend fun getChampions(page: Int, perPage: Int): List<Champion> {
        var list = championDao.getChampionList((page - 1) * perPage, perPage)
        if (list.isEmpty()) {
            list = apiService.getChampions(page, perPage)
            championDao.insertChampion(list)
        }
        return list
    }

    override suspend fun getItems(page: Int, perPage: Int): List<Item> {
        var list = itemDao.getItemList((page - 1) * perPage, perPage)
        if (list.isEmpty()) {
            list = apiService.getItems(page, perPage)
            itemDao.insertItems(list)
        }
        return list
    }

    override suspend fun getChampionsLocal(page: Int, perPage: Int): List<Champion> =
        championDao.getChampionList(page, perPage)

    override suspend fun insertChampions(champions: List<Champion>) =
        championDao.insertChampion(champions)

    override suspend fun getItemsLocal(page: Int, perPage: Int): List<Item> =
        itemDao.getItemList(page, perPage)

    override suspend fun insertItems(items: List<Item>) = itemDao.insertItems(items)

}
