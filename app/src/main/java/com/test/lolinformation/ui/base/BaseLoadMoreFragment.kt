package com.test.lolinformation.ui.base

import androidx.databinding.ViewDataBinding
import com.test.lolinformation.R

abstract class BaseLoadMoreFragment<ViewBinding : ViewDataBinding, ViewModel : BaseLoadMoreViewModel<Item>, Item> :
    BaseFragment<ViewBinding, ViewModel>() {

    override val layoutId: Int = R.layout.base_load_more_fragment

}
