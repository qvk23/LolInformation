package com.test.lolinformation.di

import com.test.lolinformation.data.local.AppDatabase
import com.test.lolinformation.data.repository.GamePlayRepository
import com.test.lolinformation.data.repository.GamePlayRepositoryImp
import com.test.lolinformation.data.repository.MatchRepository
import com.test.lolinformation.data.repository.MatchRepositoryImp
import org.koin.dsl.module

const val DATABASE_NAME = "DATABASE_NAME"
val repositoryModule = module {
    single { DATABASE_NAME }
    single { AppDatabase.getInstance(get()) }
    single { AppDatabase.getInstance(get()).championDao() }
    single { AppDatabase.getInstance(get()).itemDao() }
    single { AppDatabase.getInstance(get()).matchDao() }
    single<GamePlayRepository> { GamePlayRepositoryImp(get(), get(), get()) }
    single<MatchRepository> { MatchRepositoryImp(get(), get()) }
}
