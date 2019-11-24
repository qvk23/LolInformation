package com.test.lolinformation.ui.gameplay.champion

import com.test.lolinformation.data.local.model.Champion
import com.test.lolinformation.databinding.BaseLoadMoreFragmentBinding
import com.test.lolinformation.ui.base.BaseLoadMoreFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChampionFragment :
    BaseLoadMoreFragment<BaseLoadMoreFragmentBinding, ChampionViewModel, Champion>() {

    override val viewModel: ChampionViewModel by viewModel()

    override fun initView() {

    }

    override fun observeData() {

    }

}
