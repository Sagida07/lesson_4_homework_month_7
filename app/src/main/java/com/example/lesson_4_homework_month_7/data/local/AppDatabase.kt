package com.example.lesson_4_homework_month_7.data.local

@Database(entities = [Statistic::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): StatisticDao
}