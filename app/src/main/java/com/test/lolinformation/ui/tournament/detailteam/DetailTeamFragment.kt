package com.test.lolinformation.ui.tournament.detailteam

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.test.lolinformation.R
import com.test.lolinformation.data.local.model.Player
import com.test.lolinformation.databinding.FragmentDetailTeamBinding
import com.test.lolinformation.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_detail_team.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailTeamFragment : BaseFragment<FragmentDetailTeamBinding, DetailTeamViewModel>() {

    override val viewModel: DetailTeamViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_detail_team
    private val args: DetailTeamFragmentArgs by navArgs()
    private val playerAdapter by lazyOf(PlayerAdapter())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.apply {
            setTeam(args.team)
            setPlayers(args.team.players as ArrayList<Player>)
        }
    }

    override fun initView() {
        recyclerPlayer.adapter = playerAdapter
        toolbarTeamPreview.apply {
            setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp)
            setNavigationOnClickListener { findNavController().popBackStack() }
        }
    }

    override fun observeData() {
        viewModel.listPlayer.observe(viewLifecycleOwner, Observer(playerAdapter::submitList))
    }

    companion object {
        fun newInstance() = DetailTeamFragment()
    }
}
