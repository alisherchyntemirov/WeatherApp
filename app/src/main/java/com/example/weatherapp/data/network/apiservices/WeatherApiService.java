package com.example.weatherapp.data.network.apiservices;

import com.example.weatherapp.models.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {

    @GET("weather")
    Call<WeatherModel> getWeatherFromBishkek(
            @Query("q") String q,
            @Query("appid") String apikey,
            @Query("units") String units
    );
}
