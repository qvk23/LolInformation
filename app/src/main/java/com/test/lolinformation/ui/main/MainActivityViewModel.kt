package com.test.lolinformation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.lolinformation.ui.base.BaseViewModel

class MainActivityViewModel : BaseViewModel() {
    private val _queryText = MutableLiveData<String>()
    val queryText : LiveData<String> get() = _queryText
    fun getQuery(query: String) {
        _queryText.value = query
    }
}
