package com.test.lolinformation.ui.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.test.lolinformation.R
import com.test.lolinformation.ui.main.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

abstract class BaseLoadMoreFragment<ViewBinding : ViewDataBinding, ViewModel : BaseLoadMoreViewModel<Item>, Item> :
    BaseFragment<ViewBinding, ViewModel>() {

    override val layoutId: Int = R.layout.base_load_more_fragment
    protected val searchViewModel by sharedViewModel<MainActivityViewModel>()
    override fun observeData() {
        searchViewModel.queryText.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) viewModel.isSearching(true)
            else viewModel.apply {
                isSearching(false)
                resetLoadMore()
            }
        })
    }
}
