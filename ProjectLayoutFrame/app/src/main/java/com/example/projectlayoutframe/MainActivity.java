package com.example.projectlayoutframe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.projectlayoutframe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addPromise.setOnClickListener(view -> {
            startActivity(new Intent(this, make_promise.class));
        });

        binding.modifyButton.setOnClickListener(view -> {
            startActivity(new Intent(this, modify_promise.class));
        });

        binding.checkingProm1.setOnClickListener(view -> {
            startActivity(new Intent(this, activation_promise.class));
        });
    }
}