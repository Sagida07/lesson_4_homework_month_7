package com.example.lesson_4_homework_month_7.data.local

@Dao
interface StatisticDao {

    @Query("SELECT * FROM statistic")
    fun getAll():List<Statistic>

    @Insert
    fun insert(model:Statistic):Long

    @Delete
    fun delete(model: Statistic)

}