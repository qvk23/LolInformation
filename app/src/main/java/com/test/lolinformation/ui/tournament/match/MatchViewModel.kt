package com.test.lolinformation.ui.tournament.match

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.test.lolinformation.data.local.model.Match
import com.test.lolinformation.data.local.model.Team
import com.test.lolinformation.data.remote.api.DEFAULT_ITEM_PER_PAGE
import com.test.lolinformation.data.repository.MatchRepository
import com.test.lolinformation.ui.base.BaseLoadMoreViewModel
import kotlinx.coroutines.launch

class MatchViewModel(
    private val matchRepository: MatchRepository
) : BaseLoadMoreViewModel<Match>() {
    private val serieId = MutableLiveData<Int>()
    fun setSerieId(id: Int) {
        serieId.value = id
    }

    override fun loadData(page: Int) {
        viewModelScope.launch {
            try {
                serieId.value?.let {
                    onLoadSuccess(
                        page,
                        matchRepository.getMatchBySerie(it, page, DEFAULT_ITEM_PER_PAGE)
                    )
                }
            } catch (e: Exception) {
                onLoadFaild(e)
            }
        }
    }
}
