package com.example.domain.usecase

import com.example.domain.model.DDay
import com.example.domain.repository.DDayRepository

class AddDDayUseCase(private val repository: DDayRepository) {
    suspend operator fun invoke(dDay: DDay) = repository.insertDDay(dDay)
}