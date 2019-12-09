package com.test.lolinformation.ui.tournament.series

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.lolinformation.data.local.model.Sery
import com.test.lolinformation.data.remote.api.LCK_LEAGUE_ID
import com.test.lolinformation.data.remote.api.LEC_LEAGUE_ID
import com.test.lolinformation.data.remote.api.LPL_LEAGUE_ID
import com.test.lolinformation.databinding.BaseLoadMoreFragmentBinding
import com.test.lolinformation.ui.base.BaseLoadMoreFragment
import com.test.lolinformation.ui.tournament.TournamentPagerAdapter.Companion.LCK_ITEM
import com.test.lolinformation.ui.tournament.TournamentPagerAdapter.Companion.LEC_ITEM
import com.test.lolinformation.ui.tournament.TournamentPagerAdapter.Companion.LPL_ITEM
import kotlinx.android.synthetic.main.base_load_more_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SerieFragment : BaseLoadMoreFragment<BaseLoadMoreFragmentBinding, SerieViewModel, Sery>() {
    override val viewModel: SerieViewModel by viewModel()
    private val serieAdapter by lazy { SerieAdapter() }
    private var leagueId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val leagueName = arguments?.getString(BUNDLE_NAME)
        leagueId = when (leagueName) {
            LCK_ITEM -> LCK_LEAGUE_ID
            LPL_ITEM -> LPL_LEAGUE_ID
            else -> LEC_LEAGUE_ID
        }
        viewModel.setLeagueId(leagueId)
    }

    override fun initView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = serieAdapter
        }
    }

    override fun observeData() {
        viewModel.apply {
            listItem.observe(viewLifecycleOwner, Observer {
                serieAdapter.submitList(it)
            })
            firstLoad()
        }
    }
    companion object {
        fun newInstance(name: String) = SerieFragment().apply {
            arguments = bundleOf(BUNDLE_NAME to name)
        }
        const val BUNDLE_NAME = "BUNDLE_NAME"
    }
}
