package com.example.lowesweatherapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lowesweatherapp.databinding.WeatherFragmentBinding
import com.example.lowesweatherapp.ui.main.adapters.DailyAdapter
import com.example.lowesweatherapp.ui.main.adapters.HourlyAdapter
import java.text.SimpleDateFormat
import java.util.*

class WeatherFragment : Fragment() {

    private val viewModel by activityViewModels<MainViewModel>()

    private var _binding: WeatherFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = WeatherFragmentBinding.inflate(inflater, container, false).apply {
        toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initObservers() = with(viewModel) {
        coordInfo.observe(viewLifecycleOwner) {
            binding.toolbar.title = it.city.name
            binding.cityNameTv.text = it.city.name
            viewModel.getWeatherData(it.city.coord.lat, it.city.coord.lon)
        }

        weatherInfo.observe(viewLifecycleOwner) { weather ->
            binding.apply {

                val date = viewModel.weatherInfo.value?.current?.dt?.times(1000)?.let { Date(it) }
                currentTimeTv.text = date?.let {
                    SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH).run {
                        timeZone = TimeZone.getTimeZone("EST")
                        format(it)
                    }
                } ?: ""

                mainTempTv.text = String.format("%s°", weather.current.temp)
                feelsLikeTv.text = String.format("Feels Like: %s°", weather.current.feels_like)

                hourlyTempRv.adapter = viewModel.weatherInfo.value?.let { HourlyAdapter(it.hourly) }
                dailyTempRv.adapter = viewModel.weatherInfo.value?.let { DailyAdapter(it.daily) }
            }
        }
    }
}