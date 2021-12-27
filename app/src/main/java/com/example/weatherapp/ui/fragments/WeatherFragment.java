package com.example.weatherapp.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weatherapp.base.BaseFragment;
import com.example.weatherapp.data.repositories.WeatherRepository;
import com.example.weatherapp.databinding.FragmentWeatherBinding;
import com.example.weatherapp.ui.models.Coord;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WeatherFragment extends BaseFragment<WeatherViewModel, FragmentWeatherBinding> {

    private FragmentWeatherBinding binding;
    private WeatherViewModel viewModel;
    public WeatherFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentWeatherBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(WeatherViewModel.class);
    }

    @Override
    protected void setUpObserves() {
        viewModel.getWeather().observe(getViewLifecycleOwner(), weatherModels -> {
            binding.tvLocation.setText(weatherModels.getName());
            binding.maxTemperature.setText(String.valueOf(weatherModels.getMain().getTempMax()));
            binding.minTemperature.setText(String.valueOf(weatherModels.getMain().getTempMin()));
            binding.wind.setText(String.valueOf(weatherModels.getWind().getSpeed()));
            binding.degrees.setText(String.valueOf(weatherModels.getCoord().getLat()));
        });
    }
}