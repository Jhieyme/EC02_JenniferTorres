package com.jennifer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.jennifer.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fabAddTrip.setOnClickListener(v -> {
            Snackbar.make(binding.getRoot(), "Add a trip", Snackbar.LENGTH_SHORT).show();
        });
    }
}