package com.test.lolinformation.di

import com.test.lolinformation.ui.gameplay.container.ChampionContainerViewModel
import com.test.lolinformation.ui.gameplay.GamePlayViewModel
import com.test.lolinformation.ui.gameplay.champion.ChampionViewModel
import com.test.lolinformation.ui.gameplay.detailchamp.DetailChampionViewModel
import com.test.lolinformation.ui.gameplay.item.ItemViewModel
import com.test.lolinformation.ui.main.MainActivityViewModel
import com.test.lolinformation.ui.tournament.*
import com.test.lolinformation.ui.tournament.detailserie.SerieDetailViewModel
import com.test.lolinformation.ui.tournament.detailteam.DetailTeamViewModel
import com.test.lolinformation.ui.tournament.match.MatchViewModel
import com.test.lolinformation.ui.tournament.series.SerieViewModel
import com.test.lolinformation.ui.tournament.team.TeamViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainActivityViewModel() }
    viewModel { GamePlayViewModel() }
    viewModel { ChampionContainerViewModel() }
    viewModel { ChampionViewModel(get()) }
    viewModel { DetailChampionViewModel() }
    viewModel { ItemViewModel(get()) }
    viewModel { TournamentViewModel() }
    viewModel { SerieViewModel(get()) }
    viewModel { SerieDetailViewModel() }
    viewModel { MatchViewModel(get()) }
    viewModel { TeamViewModel(get()) }
    viewModel { DetailTeamViewModel() }
}
