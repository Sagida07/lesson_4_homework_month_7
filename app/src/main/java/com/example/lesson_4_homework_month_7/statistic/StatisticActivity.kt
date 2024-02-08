package com.example.lesson_4_homework_month_7.statistic

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson_4_homework_month_7.data.local.Statistic
import com.example.lesson_4_homework_month_7.databinding.ActivityStatisticBinding

class StatisticActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStatisticBinding
    private val viewModel: StatisticViewModel by viewModels()
    private val adapter = StatisticAdapter(this::onLongClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatisticBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter

        viewModel.getStatistic().observe(this) { e ->
            adapter.addStatistics(e)
        }
    }

    private fun onLongClick(position: Statistic): Boolean {
        val alertDialBuilder = AlertDialog.Builder(this)
            .setMessage("Do you want to delete statistic?")

            .setPositiveButton("Yes") { _, _ ->
                App.db.getDao().delete(position)
                adapter.notifyDataSetChanged()

            }
            .setNegativeButton("No") { _, _ ->
                dismissKeyboardShortcutsHelper()
            }

        val alertDialog = alertDialBuilder.create()
        alertDialog.show()
        return true
    }
}