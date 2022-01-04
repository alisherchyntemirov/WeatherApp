package com.example.weatherapp.ui.fragments.weather;

import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.base.BaseViewModel;
import com.example.weatherapp.data.repositories.WeatherRepository;
import com.example.weatherapp.models.WeatherModel;


import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
@HiltViewModel
public class WeatherViewModel extends BaseViewModel {
    String city = "Bishkek";
    private WeatherRepository repository;

    @Inject
    public WeatherViewModel(WeatherRepository repository){
        this.repository =repository;
    }

    MutableLiveData<WeatherModel> getWeather(String city) {
        return repository.getWeather(city);
    }




}

