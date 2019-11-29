package com.test.lolinformation.ui.gameplay.item

import androidx.lifecycle.viewModelScope
import com.test.lolinformation.data.local.model.Item
import com.test.lolinformation.data.repository.GamePlayRepository
import com.test.lolinformation.ui.base.BaseLoadMoreViewModel
import kotlinx.coroutines.launch

class ItemViewModel(private val gamePlayRepository: GamePlayRepository) :
    BaseLoadMoreViewModel<Item>() {

    override fun loadData(page: Int) {
        viewModelScope.launch {
            try {
                onLoadSuccess(page, items = gamePlayRepository.getItems(page, NUMBER_PER_PAGE))
            } catch (e: Exception) {
                onLoadFaild(e)
            }
        }
    }

    companion object {
        const val NUMBER_PER_PAGE = 20
    }
}
