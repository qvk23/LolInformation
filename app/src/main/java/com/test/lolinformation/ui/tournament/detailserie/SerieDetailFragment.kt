package com.test.lolinformation.ui.tournament.detailserie

import androidx.navigation.fragment.navArgs
import com.test.lolinformation.R
import com.test.lolinformation.databinding.FragmentSerieDetailBinding
import com.test.lolinformation.ui.base.BaseFragment
import com.test.lolinformation.ui.tournament.match.MatchFragment
import com.test.lolinformation.ui.tournament.team.TeamFragment
import kotlinx.android.synthetic.main.fragment_serie_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SerieDetailFragment : BaseFragment<FragmentSerieDetailBinding, SerieDetailViewModel>() {

    override val viewModel: SerieDetailViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_serie_detail
    private val args by navArgs<SerieDetailFragmentArgs>()
    override fun initView() {
        val fragments = listOf(MatchFragment.newInstance(args.id), TeamFragment.newInstance(args.id))
        val adapter = SerieDetailPagerAdapter(childFragmentManager, fragments)
        viewPagerSerieDetail.adapter = adapter
    }

    override fun observeData() {}

}
