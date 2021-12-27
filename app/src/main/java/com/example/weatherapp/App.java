package com.example.weatherapp;

import android.app.Application;

import com.example.weatherapp.data.RetrofitClient;
import com.example.weatherapp.data.network.apiservices.WeatherApiService;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
  }
}
