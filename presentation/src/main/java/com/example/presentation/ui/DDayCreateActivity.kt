package com.example.presentation.ui

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.R
import com.example.presentation.databinding.ActivityDDayCreateBinding
import com.example.presentation.viewmodel.DDayViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class DDayCreateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDDayCreateBinding
    private val viewModel by viewModels<DDayViewModel>()

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
            val year = cal.get(Calendar.YEAR)
            val month = cal.get(Calendar.MONTH)
            val day = cal.get(Calendar.DAY_OF_MONTH)
            tvDate.text = "${year}년 ${month}월 ${day}일"
            llDate.setOnClickListener {
                val datePickerDialog = DatePickerDialog(
                    this@DDayCreateActivity,
                    R.style.SpinnerDatePicker,
                    { _, year, month, day ->
                        tvDate.text = "${year}년 ${month}월 ${day}일"
                    },
                    year,
                    month,
                    day
                )
                datePickerDialog.show()
            }
        }
    }
}