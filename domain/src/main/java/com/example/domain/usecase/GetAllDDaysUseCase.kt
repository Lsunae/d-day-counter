package com.example.domain.usecase

import com.example.domain.model.DDay
import com.example.domain.repository.DDayRepository

class GetAllDDaysUseCase(private val repository: DDayRepository) {
    suspend operator fun invoke(): List<DDay> = repository.getAllDDays()
}