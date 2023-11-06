package com.example.projectlayoutframe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.projectlayoutframe.databinding.ActivityActivationPromiseBinding;
import com.example.projectlayoutframe.databinding.ActivityAfterPromiseTimeBinding;

public class after_promise_time extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAfterPromiseTimeBinding binding = ActivityAfterPromiseTimeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.goBackInMakeProm.setOnClickListener(view -> {
            Toast.makeText(this, "약속목록으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}