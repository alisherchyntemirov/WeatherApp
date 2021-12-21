package com.example.weatherapp;

import android.app.Application;

import com.example.weatherapp.data.RetrofitClient;
import com.example.weatherapp.data.network.apiservices.WeatherApiService;

public class App extends Application {
    public static WeatherApiService weatherApiService;
    public RetrofitClient retrofitClient = new RetrofitClient();

    @Override
    public void onCreate() {
        super.onCreate();
        weatherApiService = retrofitClient.provideApi();
    }
}
