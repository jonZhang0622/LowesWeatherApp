package com.example.lowesweatherapp.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lowesweatherapp.databinding.DailyItemBinding
import com.example.lowesweatherapp.ui.main.data.models.DailyDTO
import java.text.SimpleDateFormat
import java.util.*

class DailyAdapter(
    private val dataSet: List<DailyDTO>
) : RecyclerView.Adapter<DailyAdapter.DailyViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        viewGroup: ViewGroup, viewType: Int
    ) = DailyItemBinding.inflate(
        LayoutInflater.from(viewGroup.context), viewGroup, false
    ).run { DailyViewHolder(this) }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: DailyViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.loadData(dataSet[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    class DailyViewHolder(private val binding: DailyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun loadData(dailyReport: DailyDTO) = with(binding) {

            val date = Date(dailyReport.dt.toLong() * 1000)
            val sdf = SimpleDateFormat("MM/dd EEEE", Locale.ENGLISH)
            sdf.timeZone = TimeZone.getTimeZone("EST")

            binding.dayTv.text = sdf.format(date)
            binding.tempTv.text = "${dailyReport.temp.day}°"
        }
    }
}