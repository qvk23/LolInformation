package com.test.lolinformation.ui.gameplay.detailchamp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.lolinformation.data.local.model.Champion
import com.test.lolinformation.ui.base.BaseViewModel

class DetailChampionViewModel : BaseViewModel() {
    private val _champion = MutableLiveData<Champion>()
    val champion: LiveData<Champion> get() = _champion

    fun setChampionValue(value: Champion) {
        _champion.value = value
    }
}
