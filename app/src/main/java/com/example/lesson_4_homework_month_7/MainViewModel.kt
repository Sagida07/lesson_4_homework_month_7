package com.example.lesson_4_homework_month_7

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lesson_4_homework_month_7.data.Repository
import com.example.lesson_4_homework_month_7.data.local.Statistic

class MainViewModel: ViewModel() {
    private val repository = Repository()
    fun addStatistic(model: Statistic): LiveData<Long> = repository.addStatistic(model)
}