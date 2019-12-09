package com.test.lolinformation.ui.gameplay

import androidx.fragment.app.Fragment
import com.test.lolinformation.R
import com.test.lolinformation.databinding.FragmentGamePlayBinding
import com.test.lolinformation.ui.base.BaseFragment
import com.test.lolinformation.ui.gameplay.container.ChampionContainerFragment
import com.test.lolinformation.ui.gameplay.item.ItemFragment
import kotlinx.android.synthetic.main.fragment_game_play.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class GamePlayFragment : BaseFragment<FragmentGamePlayBinding, GamePlayViewModel>() {

    override val layoutId: Int = R.layout.fragment_game_play

    override val viewModel: GamePlayViewModel by viewModel()

    override fun initView() {
        tabLayoutGamePlay.setupWithViewPager(viewPagerGamePlay)
        setUpViewPager()
    }

    private fun setUpViewPager() {
        val championFragment = ChampionContainerFragment.newInstance()
        val itemFragment = ItemFragment.newInstance()
        val list = listOf<Fragment>(championFragment, itemFragment)
        val adapter = GamePlayPagerAdapter(childFragmentManager, list)
        viewPagerGamePlay.apply {
            setAdapter(adapter)
            currentItem = FIRST_PAGE
        }
    }

    override fun observeData() {}

    companion object {
        fun newInstance() = GamePlayFragment()
        const val FIRST_PAGE = 0
    }

}
