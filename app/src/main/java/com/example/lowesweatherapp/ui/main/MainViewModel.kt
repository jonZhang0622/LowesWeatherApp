package com.example.lowesweatherapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.lowesweatherapp.ui.main.data.models.CoordResponseDTO
import com.example.lowesweatherapp.ui.main.data.models.WeatherResponseDTO
import com.example.lowesweatherapp.ui.main.data.repos.WeatherRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    private val disposable = CompositeDisposable()

    private var _coordInfo = MutableLiveData<CoordResponseDTO>()
    val coordInfo: LiveData<CoordResponseDTO> get() = _coordInfo

    private var _weatherInfo = MutableLiveData<WeatherResponseDTO>()
    val weatherInfo: LiveData<WeatherResponseDTO> get() = _weatherInfo

    init {
        getCoordsData("")
    }

    fun getCoordsData(city: String) = WeatherRepo.getCoord(city)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ _coordInfo.value = it }, this::onGetError)
        .also { disposable.add(it) }

    fun getWeatherData(
        lat: String, lon: String
    ) = WeatherRepo.getWeather(lat, lon)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ _weatherInfo.value = it }, this::onGetError)
        .also { disposable.add(it) }

    private fun onGetError(e: Throwable) {
        Log.d(TAG, e.message.toString())
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

    companion object {
        private val TAG = MainViewModel::class.java.name
    }
}