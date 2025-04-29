package com.example.data.di

import com.example.data.dao.DDayDao
import com.example.data.source.DDayLocalDataSourceImpl
import com.example.domain.source.DDayLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Provides
    @Singleton
    fun provideDDayDatasource(dDayDao: DDayDao): DDayLocalDataSource =
        DDayLocalDataSourceImpl(dDayDao)
}