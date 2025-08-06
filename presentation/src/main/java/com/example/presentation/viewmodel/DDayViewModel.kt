package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DDay
import com.example.domain.usecase.AddDDayUseCase
import com.example.domain.usecase.DeleteDDayUseCase
import com.example.domain.usecase.GetAllDDaysUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DDayViewModel @Inject constructor(
    private val getAllDDaysUseCase: GetAllDDaysUseCase,
    private val addDDayUseCase: AddDDayUseCase,
    private val deleteDDayUseCase: DeleteDDayUseCase
) : ViewModel() {
    private val _dDays = MutableLiveData<List<DDay>>()
    val dDays: LiveData<List<DDay>> = _dDays

    private val _addResult = MutableLiveData<Boolean>()
    val addResult: LiveData<Boolean> = _addResult

    fun getDDays() {
        viewModelScope.launch {
            _dDays.value = getAllDDaysUseCase()
        }
    }

    fun addDDay(dDay: DDay) {
        viewModelScope.launch {
            try {
                addDDayUseCase(dDay)
                _addResult.value = true
                getDDays()
            } catch (e: Exception) {
                _addResult.value = false
            }
        }
    }

    fun deleteDDay(dDay: DDay) {
        viewModelScope.launch {
            deleteDDayUseCase(dDay)
            getDDays()
        }
    }
}