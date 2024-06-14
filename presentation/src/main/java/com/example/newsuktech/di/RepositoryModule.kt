package com.example.newsuktech.di

import com.example.data.repository.CoinsRepositoryImpl
import com.example.domain.repository.CoinsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindCoinsRepository(impl: CoinsRepositoryImpl): CoinsRepository

}