package com.example.data.repository

import com.example.domain.model.DDay
import com.example.domain.repository.DDayRepository
import com.example.domain.source.DDayLocalDataSource
import javax.inject.Inject

class DDayRepositoryImpl @Inject constructor(private val localDataSource: DDayLocalDataSource) :
    DDayRepository {
    override suspend fun getAllDDays(): List<DDay> = localDataSource.getAllDDays()

    override suspend fun insertDDay(dDay: DDay) = localDataSource.insertDDay(dDay)

    override suspend fun deleteDDay(dDay: DDay) = localDataSource.deleteDDay(dDay)
}