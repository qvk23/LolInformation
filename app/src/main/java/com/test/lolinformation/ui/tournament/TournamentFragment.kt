package com.test.lolinformation.ui.tournament

import com.test.lolinformation.R
import com.test.lolinformation.databinding.FragmentTournamentBinding
import com.test.lolinformation.ui.base.BaseFragment
import com.test.lolinformation.ui.tournament.TournamentPagerAdapter.Companion.LCK_ITEM
import com.test.lolinformation.ui.tournament.TournamentPagerAdapter.Companion.LEC_ITEM
import com.test.lolinformation.ui.tournament.TournamentPagerAdapter.Companion.LPL_ITEM
import kotlinx.android.synthetic.main.fragment_tournament.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TournamentFragment : BaseFragment<FragmentTournamentBinding, TournamentViewModel>() {

    override val layoutId: Int = R.layout.fragment_tournament

    override val viewModel: TournamentViewModel by viewModel()

    override fun initView() {
        tabLayoutTour.setupWithViewPager(viewPagerTour)
        setUpViewPager()
    }

    private fun setUpViewPager() {
        val list = listOf(LCK_ITEM, LPL_ITEM, LEC_ITEM)
        val adapter = TournamentPagerAdapter(childFragmentManager, list)
        viewPagerTour.apply {
            setAdapter(adapter)
            currentItem = 0
        }
    }

    override fun observeData() {}
}
