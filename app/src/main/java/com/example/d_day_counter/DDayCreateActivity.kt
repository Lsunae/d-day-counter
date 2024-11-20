package com.example.d_day_counter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.d_day_counter.databinding.ActivityDDayCreateBinding

class DDayCreateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDDayCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDDayCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}