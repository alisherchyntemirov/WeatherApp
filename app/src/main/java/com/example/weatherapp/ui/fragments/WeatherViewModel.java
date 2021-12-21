package com.example.weatherapp.ui.fragments;

import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.base.BaseViewModel;
import com.example.weatherapp.data.repositories.WeatherRepository;
import com.example.weatherapp.ui.models.WeatherModel;

import java.util.ArrayList;

public class WeatherViewModel extends BaseViewModel {

    String city = "Bishkek";
    private final WeatherRepository repository = new WeatherRepository();

    MutableLiveData<WeatherModel> getWeather() {
        return repository.getWeather(city);
    }
}
