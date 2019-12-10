package com.test.lolinformation.di

import com.test.lolinformation.data.local.AppDatabase
import com.test.lolinformation.data.repository.GamePlayRepository
import com.test.lolinformation.data.repository.GamePlayRepositoryImp
import com.test.lolinformation.data.repository.MatchRepository
import com.test.lolinformation.data.repository.MatchRepositoryImp
import org.koin.dsl.module

val repositoryModule = module {
    single<GamePlayRepository> { GamePlayRepositoryImp(get(), get(), get()) }
    single<MatchRepository> { MatchRepositoryImp(get()) }
    single { AppDatabase.getInstance(get()) }
    single { AppDatabase.getInstance(get()).championDao() }
    single { AppDatabase.getInstance(get()).itemDao() }
}
