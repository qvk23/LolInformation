package com.test.lolinformation.ui.tournament.detailserie

import androidx.navigation.fragment.navArgs
import com.test.lolinformation.R
import com.test.lolinformation.databinding.FragmentSerieDetailBinding
import com.test.lolinformation.ui.base.BaseFragment
import com.test.lolinformation.ui.tournament.TournamentPagerAdapter.Companion.LCK_ITEM
import com.test.lolinformation.ui.tournament.TournamentPagerAdapter.Companion.LEC_ITEM
import com.test.lolinformation.ui.tournament.TournamentPagerAdapter.Companion.LPL_ITEM
import kotlinx.android.synthetic.main.fragment_serie_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SerieDetailFragment : BaseFragment<FragmentSerieDetailBinding, SerieDetailViewModel>() {

    override val viewModel: SerieDetailViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_serie_detail
    private val args by navArgs<SerieDetailFragmentArgs>()
    override fun initView() {
        val list = listOf(LCK_ITEM, LPL_ITEM, LEC_ITEM)
        val adapter = SerieDetailPagerAdapter(childFragmentManager, list)
        pageSerieDetail.adapter = adapter
    }

    override fun observeData() {}
}
