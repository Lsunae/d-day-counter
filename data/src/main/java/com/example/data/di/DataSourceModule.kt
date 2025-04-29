package com.example.data.di

import com.example.data.dao.DDayDao
import com.example.data.source.DDayLocalDataSourceImpl
import com.example.domain.source.DDayLocalDataSource
import dagger.Provides
import javax.inject.Singleton

class DataSourceModule {
    @Provides
    @Singleton
    fun provideDDayDatasource(dDayDao: DDayDao): DDayLocalDataSource =
        DDayLocalDataSourceImpl(dDayDao)
}