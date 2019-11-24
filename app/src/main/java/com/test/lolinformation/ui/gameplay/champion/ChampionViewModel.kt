package com.test.lolinformation.ui.gameplay.champion

import com.test.lolinformation.data.local.model.Champion
import com.test.lolinformation.data.repository.GamePlayRepository
import com.test.lolinformation.ui.base.BaseLoadMoreViewModel

class ChampionViewModel(private val gamePlayRepository: GamePlayRepository) :
    BaseLoadMoreViewModel<Champion>() {

    override fun loadData(page: Int) {

    }
}
