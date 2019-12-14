package com.test.lolinformation.ui.gameplay.champion

import androidx.lifecycle.viewModelScope
import com.test.lolinformation.data.local.model.Champion
import com.test.lolinformation.data.remote.api.DEFAULT_ITEM_PER_PAGE
import com.test.lolinformation.data.repository.GamePlayRepository
import com.test.lolinformation.ui.base.BaseLoadMoreViewModel
import kotlinx.coroutines.launch

class ChampionViewModel(private val gamePlayRepository: GamePlayRepository) :
    BaseLoadMoreViewModel<Champion>() {

    override fun loadData(page: Int) {
        viewModelScope.launch {
            try {
                val champions = gamePlayRepository.getChampions(page, DEFAULT_ITEM_PER_PAGE)
                onLoadSuccess(page, champions)
            } catch (e: Exception) {
                onLoadFaild(e)
            }
        }
    }
}
