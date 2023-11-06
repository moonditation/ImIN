package com.example.projectlayoutframe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.projectlayoutframe.databinding.ActivityModifyPromiseBinding;

public class modify_promise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityModifyPromiseBinding binding = ActivityModifyPromiseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.goBackInMakeProm.setOnClickListener(view -> {
            Toast.makeText(this, "저장하지 않는다. 경고문구 띄우기.", Toast.LENGTH_SHORT).show();
            finish();
        });

        binding.complete.setOnClickListener(view -> {
            Toast.makeText(this, "약속 일정이 저장되었습니다.", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}