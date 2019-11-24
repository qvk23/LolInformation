package com.test.lolinformation.ui.widget

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessScrollingRecycler : RecyclerView.OnScrollListener() {

    private var isLoading = true
    private var previousTotal: Int = 0
    private val visibleThreshold = 10
    private var firstVisibleItem: Int = 0
    private var visibleItemCount: Int = 0
    private var totalItemCount: Int = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        visibleItemCount = recyclerView.childCount
        totalItemCount = recyclerView.layoutManager?.itemCount ?: 0

        getFirstVisibleItem(recyclerView)

        if (isLoading) stateLoading()
        if (!isLoading
            && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)
        ) {
            onLoadMore()
            isLoading = true
        }

    }

    private fun getFirstVisibleItem(recyclerView: RecyclerView) {
        when (val layoutManager = recyclerView.layoutManager) {
            is LinearLayoutManager -> {
                firstVisibleItem = layoutManager.findFirstVisibleItemPosition()
            }
            is GridLayoutManager -> {
                firstVisibleItem = layoutManager.findFirstVisibleItemPosition()
            }
        }
    }

    abstract fun onLoadMore()

    fun resetOnLoadMore() {
        firstVisibleItem = 0
        visibleItemCount = 0
        totalItemCount = 0
        previousTotal = 0
        isLoading = true
    }

    private fun stateLoading() {
        if (totalItemCount > previousTotal) {
            isLoading = false
            previousTotal = totalItemCount
        }
    }
}
