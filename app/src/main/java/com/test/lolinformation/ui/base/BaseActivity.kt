package com.test.lolinformation.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.test.lolinformation.BR

abstract class BaseActivity<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> :
    AppCompatActivity() {

    lateinit var viewBinding: ViewBinding
    abstract val viewModel: ViewModel
    @get:LayoutRes
    abstract val layoutId: Int
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        initView()
    }

    private fun initViewBinding() {
        viewBinding = DataBindingUtil.setContentView(this, layoutId)
        viewBinding.setVariable(BR.viewModel, viewModel)
        viewBinding.lifecycleOwner = this
    }

    protected abstract fun initView()

}
