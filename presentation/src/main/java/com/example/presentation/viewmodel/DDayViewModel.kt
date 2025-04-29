package com.example.presentation.viewmodel

import com.example.domain.usecase.AddDDayUseCase
import com.example.domain.usecase.DeleteDDayUseCase
import com.example.domain.usecase.GetAllDDaysUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DDayViewModel @Inject constructor(
    getAllDDaysUseCase: GetAllDDaysUseCase,
    addDDayUseCase: AddDDayUseCase,
    deleteDDayUseCase: DeleteDDayUseCase
) {

}