package com.test.lolinformation.ui.gameplay.container

import com.test.lolinformation.R
import com.test.lolinformation.databinding.ChampionContainerFragmentBinding
import com.test.lolinformation.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChampionContainerFragment :
    BaseFragment<ChampionContainerFragmentBinding, ChampionContainerViewModel>() {

    override val viewModel: ChampionContainerViewModel by viewModel()

    override val layoutId: Int = R.layout.champion_container_fragment

    override fun initView() {

    }

    override fun observeData() {}

    companion object {
        fun newInstance() =
            ChampionContainerFragment()
    }

}
