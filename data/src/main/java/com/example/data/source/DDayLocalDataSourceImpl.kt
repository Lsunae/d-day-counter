package com.example.data.source

import com.example.data.dao.DDayDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.domain.model.DDay
import com.example.domain.source.DDayLocalDataSource
import javax.inject.Inject

class DDayLocalDataSourceImpl @Inject constructor(private val dDayDao: DDayDao) :
    DDayLocalDataSource {
    override suspend fun getAllDDays(): List<DDay> = dDayDao.getAllDDays().map { it.toDomain() }

    override suspend fun insertDDay(dDay: DDay) = dDayDao.insertDDay(dDay.toEntity())

    override suspend fun deleteDDay(dDay: DDay) = dDayDao.deleteDDay(dDay.toEntity())
}