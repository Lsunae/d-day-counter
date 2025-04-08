package com.example.domain.repository

import com.example.domain.model.DDay

interface DDayRepository {
    suspend fun getAllDDays(): List<DDay>
    suspend fun insertDDay(dDay: DDay)
    suspend fun deleteDDay(dDay: DDay)
}