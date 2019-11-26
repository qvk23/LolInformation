package com.test.lolinformation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.test.lolinformation.BR

abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : Fragment() {

    lateinit var viewBinding: ViewBinding
    abstract val viewModel: ViewModel
    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewBinding()
        initView()
    }

    private fun initViewBinding() {
        viewBinding.apply {
            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }
    }

    protected abstract fun initView()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeLoading()
        observeData()
    }

    private fun observeLoading() {
        viewModel.apply {
            isLoading.observe(viewLifecycleOwner, Observer(::handleShowLoading))
            errorMessage.observe(viewLifecycleOwner, Observer {
                hideLoading()
                if (it.isNullOrBlank().not()) {
                    handleShowErrorMessage(it)
                }
            })
        }
    }

    private fun handleShowLoading(isLoading: Boolean?) {
        if (isLoading == true) showLoading() else hideLoading()
    }

    open fun showLoading() {}

    open fun hideLoading() {}

    private fun handleShowErrorMessage(msg: String?) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    abstract fun observeData()
}
