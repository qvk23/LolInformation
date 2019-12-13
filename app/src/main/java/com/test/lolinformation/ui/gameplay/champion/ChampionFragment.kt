package com.test.lolinformation.ui.gameplay.champion

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.test.lolinformation.data.local.model.Champion
import com.test.lolinformation.databinding.BaseLoadMoreFragmentBinding
import com.test.lolinformation.ui.base.BaseLoadMoreFragment
import com.test.lolinformation.ui.main.MainActivityViewModel
import kotlinx.android.synthetic.main.base_load_more_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChampionFragment :
    BaseLoadMoreFragment<BaseLoadMoreFragmentBinding, ChampionViewModel, Champion>() {
    private val championAdapter by lazy {
        ChampionAdapter(
            onItemClick = {
                findNavController().navigate(
                    ChampionFragmentDirections.actionChampionFragmentToDetailChampionFragment(it)
                )
            }
        )
    }
    override val viewModel: ChampionViewModel by viewModel()

    override fun initView() {
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, SPAN_COUNT)
            adapter = championAdapter
        }
    }

    override fun observeData() {
        super.observeData()
        viewModel.apply {
            listItem.observe(viewLifecycleOwner, Observer {
                championAdapter.apply {
                    submitList(it)
                    setFullList(it)
                }
            })
            firstLoad()
        }
        searchViewModel.queryText.observe(viewLifecycleOwner, Observer(championAdapter.filter::filter))
    }

    companion object {
        const val SPAN_COUNT = 3
    }

}
