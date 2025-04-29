package com.example.domain.usecase

import com.example.domain.model.DDay
import com.example.domain.repository.DDayRepository

class DeleteDDayUseCase(private val repository: DDayRepository) {
    suspend operator fun invoke(dDay: DDay) = repository.deleteDDay(dDay)
}