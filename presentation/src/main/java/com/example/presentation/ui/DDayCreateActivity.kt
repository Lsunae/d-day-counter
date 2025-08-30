package com.example.presentation.ui

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.model.DDay
import com.example.presentation.R
import com.example.presentation.databinding.ActivityDDayCreateBinding
import com.example.presentation.util.setOnSingleClickListener
import com.example.presentation.viewmodel.DDayViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class DDayCreateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDDayCreateBinding
    private val viewModel by viewModels<DDayViewModel>()
    private var selectedYear = 0
    private var selectedMonth = 0
    private var selectedDay = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDDayCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        clickListener()
    }

    @SuppressLint("SetTextI18n")
    private fun clickListener() {
        binding.run {
            ivClose.setOnClickListener { finish() }

            val cal = Calendar.getInstance()
            selectedYear = cal.get(Calendar.YEAR)
            selectedMonth = cal.get(Calendar.MONTH)
            selectedDay = cal.get(Calendar.DAY_OF_MONTH)
            tvDate.text = "${selectedYear}년 ${selectedMonth}월 ${selectedDay}일"
            llDate.setOnClickListener {
                val datePickerDialog = DatePickerDialog(
                    this@DDayCreateActivity,
                    R.style.SpinnerDatePicker,
                    { _, year, month, day ->
                        selectedYear = year
                        selectedMonth = month
                        selectedDay = day
                        tvDate.text = "${year}년 ${month}월 ${day}일"
                    },
                    selectedYear,
                    selectedMonth,
                    selectedDay
                )
                datePickerDialog.show()
            }

            tvSave.setOnSingleClickListener {
                val title = etTitle.text.toString().trim()
                if (title.isBlank()) {
                    etTitle.error = getString(R.string.d_day_title_hint)
                    return@setOnSingleClickListener
                }
                val calForEpoch = Calendar.getInstance().apply {
                    // DatePicker/Calendar의 month는 0부터 시작하므로 그대로 사용
                    set(selectedYear, selectedMonth, selectedDay, 0, 0, 0)
                    set(Calendar.MILLISECOND, 0)
                }
                val epochMilli = calForEpoch.timeInMillis
                val dDay = DDay(
                    id = 0,
                    title = title,
                    date = epochMilli
                )

                viewModel.addDDay(dDay)
            }
        }
    }
}