package com.example.data.di

import com.example.data.repository.DDayRepositoryImpl
import com.example.domain.repository.DDayRepository
import com.example.domain.source.DDayLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideDDayRepository(localDataSource: DDayLocalDataSource): DDayRepository =
        DDayRepositoryImpl(localDataSource)
}