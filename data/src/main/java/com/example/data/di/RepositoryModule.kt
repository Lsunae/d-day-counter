package com.example.data.di

import com.example.data.repository.DDayRepositoryImpl
import com.example.domain.repository.DDayRepository
import com.example.domain.source.DDayLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideDDayRepository(localDataSource: DDayLocalDataSource): DDayRepository {
        return DDayRepositoryImpl(localDataSource)
    }
}