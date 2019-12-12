package com.test.lolinformation.ui.tournament.match

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.lolinformation.data.local.model.Match
import com.test.lolinformation.databinding.BaseLoadMoreFragmentBinding
import com.test.lolinformation.ui.base.BaseLoadMoreFragment
import kotlinx.android.synthetic.main.base_load_more_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MatchFragment : BaseLoadMoreFragment<BaseLoadMoreFragmentBinding, MatchViewModel, Match>() {

    override val viewModel: MatchViewModel by viewModel()
    private val matchAdapter by lazyOf(MatchAdapter())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val key = arguments?.getInt(SERIE_ID)
        key?.let(viewModel::setSerieId)
    }

    override fun initView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = matchAdapter
        }
    }

    override fun observeData() {
        viewModel.apply {
            listItem.observe(viewLifecycleOwner, Observer(matchAdapter::submitList))
            firstLoad()
        }
    }

    companion object {
        fun newInstance(id: Int) = MatchFragment().apply {
            arguments = bundleOf(SERIE_ID to id)
        }

        const val SERIE_ID = "serie_id"
    }
}
