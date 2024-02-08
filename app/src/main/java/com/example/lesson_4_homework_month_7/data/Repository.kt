package com.example.lesson_4_homework_month_7.data

class Repository {
    fun addStatistic(model: Statistic): LiveData<Long> = liveData(Dispatchers.IO) {
        val insertedId = App.db.getDao().insert(model)
        emit(insertedId)
    }
    fun getStatistic(): LiveData<List<Statistic>> = liveData(Dispatchers.Main) {
        emit(App.db.getDao().getAll())
    }
}