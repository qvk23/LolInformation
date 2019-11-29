package com.test.lolinformation.ui.gameplay.item

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.lolinformation.data.local.model.Item
import com.test.lolinformation.databinding.BaseLoadMoreFragmentBinding
import com.test.lolinformation.ui.base.BaseLoadMoreFragment
import kotlinx.android.synthetic.main.base_load_more_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemFragment : BaseLoadMoreFragment<BaseLoadMoreFragmentBinding, ItemViewModel, Item>() {

    override val viewModel: ItemViewModel by viewModel()
    private val itemAdapter by lazy { ItemAdapter() }

    override fun initView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = itemAdapter
        }
    }

    override fun observeData() {
        viewModel.apply {
            listItem.observe(viewLifecycleOwner, Observer {
                itemAdapter.submitList(it)
            })
            firstLoad()
        }
    }

    companion object {
        fun newInstance() = ItemFragment()
    }
}
