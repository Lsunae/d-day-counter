package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.dao.DDayDao
import com.example.data.database.DDayDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDDayDatabase(@ApplicationContext context: Context): DDayDatabase =
        Room.databaseBuilder(
            context,
            DDayDatabase::class.java,
            "dday_database"
        ).build()

    @Provides
    fun provideDDayDao(database: DDayDatabase): DDayDao = database.dDayDao()
}