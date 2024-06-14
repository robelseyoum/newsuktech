package com.example.newsuktech.di

import com.example.data.repository.CoinDetailRepositoryImpl
import com.example.data.repository.CoinsListRepositoryImpl
import com.example.domain.repository.CoinDetailRepository
import com.example.domain.repository.CoinsListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindCoinsRepository(impl: CoinsListRepositoryImpl): CoinsListRepository
    @Binds
    abstract fun bindCoinDetailRepository(impl: CoinDetailRepositoryImpl): CoinDetailRepository

}