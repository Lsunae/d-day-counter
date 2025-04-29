package com.example.domain.di

import com.example.domain.repository.DDayRepository
import com.example.domain.usecase.AddDDayUseCase
import com.example.domain.usecase.DeleteDDayUseCase
import com.example.domain.usecase.GetAllDDaysUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetAllDDaysUseCase(repository: DDayRepository): GetAllDDaysUseCase =
        GetAllDDaysUseCase(repository)

    @Provides
    fun provideAddDDayUseCase(repository: DDayRepository): AddDDayUseCase =
        AddDDayUseCase(repository)

    @Provides
    fun provideDeleteDDayUseCase(repository: DDayRepository): DeleteDDayUseCase =
        DeleteDDayUseCase(repository)
}