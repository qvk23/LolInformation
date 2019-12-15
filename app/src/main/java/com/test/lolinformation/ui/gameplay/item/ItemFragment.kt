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
        super.observeData()
        viewModel.apply {
            listItem.observe(viewLifecycleOwner, Observer {
                itemAdapter.apply {
                    submitList(it)
                    setFullList(it)
                }
            })
            firstLoad()
        }
        searchViewModel.queryText.observe(viewLifecycleOwner, Observer (itemAdapter.filter::filter))
    }

    companion object {
        fun newInstance() = ItemFragment()
    }
}
