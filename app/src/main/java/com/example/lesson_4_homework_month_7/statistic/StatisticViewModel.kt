package com.example.lesson_4_homework_month_7.statistic

import androidx.lifecycle.ViewModel
import com.example.lesson_4_homework_month_7.data.Repository
import com.example.lesson_4_homework_month_7.data.local.Statistic

class StatisticViewModel: ViewModel() {
    private val repository = Repository()
    fun getStatistic():LiveData<List<Statistic>> = repository.getStatistic()
}