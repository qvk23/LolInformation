package com.test.lolinformation.di

import com.test.lolinformation.ui.gameplay.container.ChampionContainerViewModel
import com.test.lolinformation.ui.gameplay.GamePlayViewModel
import com.test.lolinformation.ui.gameplay.champion.ChampionViewModel
import com.test.lolinformation.ui.main.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainActivityViewModel() }
    viewModel { GamePlayViewModel() }
    viewModel { ChampionContainerViewModel() }
    viewModel { ChampionViewModel(get()) }
}
