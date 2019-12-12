package com.test.lolinformation.ui.tournament.team

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.GridLayoutManager
import com.test.lolinformation.data.local.model.Team
import com.test.lolinformation.databinding.BaseLoadMoreFragmentBinding
import com.test.lolinformation.ui.base.BaseLoadMoreFragment
import kotlinx.android.synthetic.main.base_load_more_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamFragment private constructor() : BaseLoadMoreFragment<BaseLoadMoreFragmentBinding, TeamViewModel, Team>() {

    override val viewModel: TeamViewModel by viewModel()
    private val teamAdapter by lazy { TeamAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val key = arguments?.getInt(SERIE_ID)
    }

    override fun initView() {
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, SPAN_COUNT)
            adapter = teamAdapter
        }
    }

    override fun observeData() {
    }

    companion object {
        fun newInstance(id: Int) = TeamFragment().apply {
            arguments = bundleOf(SERIE_ID to id)
        }
        const val SERIE_ID = "serie_id"
        const val SPAN_COUNT = 3
    }
}
