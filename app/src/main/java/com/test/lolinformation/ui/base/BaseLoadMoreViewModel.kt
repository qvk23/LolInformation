package com.test.lolinformation.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.test.lolinformation.ui.widget.EndlessScrollingRecycler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseLoadMoreViewModel<Item>() : BaseViewModel() {

    private val currentPage = MutableLiveData<Int>().apply { value = FIRST_PAGE_LOAD - 1 }
    private val _listItem = MutableLiveData<ArrayList<Item>>()
    val listItem: LiveData<ArrayList<Item>> get() = _listItem
    private val _isLoadMore = MutableLiveData<Boolean>().apply { value = false }
    val isLoadMore: LiveData<Boolean> get() = _isLoadMore
    private val _isRefreshing = MutableLiveData<Boolean>().apply { value = false }
    val isRefreshing: LiveData<Boolean> get() = _isRefreshing

    fun firstLoad() {
        if (isFirst()) {
            showLoading()
            loadData(FIRST_PAGE_LOAD)
        }
    }

    private fun isFirst() =
        currentPage.value == FIRST_PAGE_LOAD - 1 && _listItem.value?.isEmpty() ?: true

    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        if (isLoading.value == true || _isRefreshing.value == true)
            return@OnRefreshListener
        _isRefreshing.value = true
        refreshData()
    }

    val onScrollListener = object : EndlessScrollingRecycler() {
        override fun onLoadMore() {
            if (isLoading.value == true
                || isLoadMore.value == true
                || isRefreshing.value == true
            ) return
            _isLoadMore.value = true
            showLoading()
            loadMore()
        }
    }

    private fun refreshData() {
        loadData(FIRST_PAGE_LOAD)
    }

    private fun loadMore() {
        loadData(currentPage.value?.plus(1) ?: FIRST_PAGE_LOAD)
    }

    fun resetLoadMore() {
        onScrollListener.resetOnLoadMore()
    }

    abstract fun loadData(page: Int)

    suspend fun onLoadSuccess(page: Int, items: List<Item>?) {
        withContext(Dispatchers.Main) {
            currentPage.value = page
            if (currentPage.value == FIRST_PAGE_LOAD) listItem.value?.clear()
            if (isRefreshing.value == true) resetLoadMore()
            val newList = _listItem.value ?: ArrayList()
            newList.addAll(items ?: listOf())
            _listItem.value = newList
            hideLoading()
            _isRefreshing.value = false
            _isLoadMore.value = false
        }
    }

    suspend fun onLoadFaild(throwable: Throwable) {
        withContext(Dispatchers.Main) {
            super.showError(throwable)
            _isLoadMore.value = false
            _isRefreshing.value = false
        }
    }

    companion object {
        const val FIRST_PAGE_LOAD = 1
    }
}
