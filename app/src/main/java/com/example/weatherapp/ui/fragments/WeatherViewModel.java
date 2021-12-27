package com.example.weatherapp.ui.fragments;

import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.base.BaseViewModel;
import com.example.weatherapp.data.repositories.WeatherRepository;
import com.example.weatherapp.ui.models.WeatherModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import okhttp3.OkHttpClient;
@HiltViewModel
public class WeatherViewModel extends BaseViewModel {
    String city = "Bishkek";
    private WeatherRepository repository;
    @Inject
    public WeatherViewModel(WeatherRepository repository){
        this.repository =repository;
    }
    MutableLiveData<WeatherModel> getWeather() {
        return repository.getWeather(city);
    }
}
