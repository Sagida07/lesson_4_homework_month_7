package com.example.lesson_4_homework_month_7.statistic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_4_homework_month_7.data.local.Statistic

class StatisticAdapter(val onClick: (statistic: Statistic) -> Boolean) :
    RecyclerView.Adapter<StatisticAdapter.StatisticsViewHolder>() {

    private val list = arrayListOf<Statistic>()

    fun addStatistics(models: List<Statistic>) {
        list.clear()
        list.addAll(models)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsViewHolder {
        return StatisticsViewHolder(
            ItemStatisticBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) =
        holder.bind(list[position])

    inner class StatisticsViewHolder(private val binding: ItemStatisticBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(statistic: Statistic) = with(binding) {
            tvStatusDetail.text = statistic.status?.replace("Result: ", "")
            tvDifficultyDetail.text = statistic.difficulty?.replace("Difficulty: ", "")
            tvMistakesDetail.text = statistic.mistakes
            imgIcon.setImageResource(if (statistic.status.equals("Result: Win")) R.drawable.ic_like else R.drawable.ic_dislike)
            imgSettings.setOnClickListener {
                onClick(statistic)
            }
        }

    }
}