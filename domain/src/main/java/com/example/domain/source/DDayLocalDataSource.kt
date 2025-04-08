package com.example.domain.source

import com.example.domain.model.DDay

interface DDayLocalDataSource {
    suspend fun getAllDDays(): List<DDay>
    suspend fun insertDDay(dDay: DDay)
    suspend fun deleteDDay(dDay: DDay)
}