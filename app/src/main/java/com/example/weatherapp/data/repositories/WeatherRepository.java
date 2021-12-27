package com.example.weatherapp.data.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.App;
import com.example.weatherapp.data.network.apiservices.WeatherApiService;
import com.example.weatherapp.ui.models.WeatherModel;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {
    private WeatherApiService apiService;

    String apiKey = "34f284ef687268abb84bca32a3522cf7";
    String units = "metric";
    @Inject
    public WeatherRepository(WeatherApiService apiService) {
        this.apiService=apiService;

    }

    public MutableLiveData<WeatherModel> getWeather(String city) {
        MutableLiveData<WeatherModel> data = new MutableLiveData<>();
        apiService.getWeatherFromBishkek(city, apiKey, units).enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
