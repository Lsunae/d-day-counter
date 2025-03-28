package com.example.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.R
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.ui.adapter.DDayRvAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dDayAdapter: DDayRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupView()
        setAdapter()
    }

    private fun setupView() {
        binding.apply {
            fbPlus.setOnClickListener {
                val intent = Intent(this@MainActivity, DDayCreateActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setAdapter() {
        dDayAdapter = DDayRvAdapter()
        binding.rvDDay.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = dDayAdapter
        }
    }
}