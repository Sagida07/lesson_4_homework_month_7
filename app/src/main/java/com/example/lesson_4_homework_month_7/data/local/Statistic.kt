package com.example.lesson_4_homework_month_7.data.local

@Entity(tableName = "statistic")
data class Statistic(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val status: String? = null,
    val difficulty: String? = null,
    val mistakes: String? = null,
    val result: String? = null,
) : Serializable