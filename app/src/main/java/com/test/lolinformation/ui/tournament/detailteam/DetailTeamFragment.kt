package com.test.lolinformation.ui.tournament.detailteam

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.test.lolinformation.R
import com.test.lolinformation.databinding.FragmentTeamDetailBinding
import com.test.lolinformation.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailTeamFragment private constructor() : BaseFragment<FragmentTeamDetailBinding, DetailTeamViewModel>() {

    override val viewModel: DetailTeamViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_team_detail
    private val args: DetailTeamFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val key = args.team
    }
    override fun initView() {

    }

    override fun observeData() {
    }

    companion object {
        fun newInstance() = DetailTeamFragment()
    }

}
