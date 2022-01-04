package com.example.weatherapp.ui.fragments.city;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.databinding.FragmentCityBinding;
import com.example.weatherapp.ui.fragments.weather.WeatherViewModel;

import java.text.DecimalFormat;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CityFragment extends Fragment {

    private FragmentCityBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCityBinding.inflate(inflater, container, false);
        setSelectedItem();
        return binding.getRoot();
    }


    public void setSelectedItem() {
        binding.mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(CityFragmentDirections.actionCityFragmentToWeatherFragment().setCityName(binding.userField.getText().toString().trim()));

            }
        });
    }

}


