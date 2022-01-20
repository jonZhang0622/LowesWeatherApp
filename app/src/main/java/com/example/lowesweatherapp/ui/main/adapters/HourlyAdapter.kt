package com.example.lowesweatherapp.ui.main.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lowesweatherapp.R
import com.example.lowesweatherapp.databinding.HourlyItemBinding
import com.example.lowesweatherapp.ui.main.data.models.HourlyDTO
import java.text.SimpleDateFormat
import java.util.*

class HourlyAdapter(private val dataSet: List<HourlyDTO>) :
    RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HourlyViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = HourlyItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)

        return HourlyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: HourlyViewHolder, position: Int): Unit = with(viewHolder){

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val hourlyReport = dataSet[position]
        loadData(hourlyReport)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    class HourlyViewHolder(private val binding: HourlyItemBinding):
        RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun loadData(hourlyReport: HourlyDTO) = with(binding) {

            val date = Date(hourlyReport.dt.toLong()*1000)
            val sdf = SimpleDateFormat("MM/dd ha", Locale.ENGLISH)
            sdf.timeZone = TimeZone.getTimeZone("EST")

            binding.hourTv.text = sdf.format(date)
            binding.tempTv.text = "${hourlyReport.temp}°"
        }
    }

}