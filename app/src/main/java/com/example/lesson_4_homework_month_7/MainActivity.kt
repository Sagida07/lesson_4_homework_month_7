package com.example.lesson_4_homework_month_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        binding.btnAdd.setOnClickListener {
            val data = Statistic(
                status = binding.spinner.selectedItem.toString(),
                difficulty = binding.difficultySpinner.selectedItem.toString(),
                mistakes = binding.etMistakes.text.toString(),
            )
            if (binding.etMistakes.text!!.isEmpty() && binding.etPoint.text!!.isEmpty()) {
                Toast.makeText(this, "Set", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.addStatistic(data).observe(this) {
                    if (it != -1L) {
                        Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Data didn't add successfully", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.btnStatistics.setOnClickListener {
            val intent = Intent(this, StatisticsActivity::class.java)
            startActivity(intent)
        }
    }
}