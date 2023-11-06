package com.example.projectlayoutframe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.projectlayoutframe.databinding.ActivityMakePromiseBinding;
import com.example.projectlayoutframe.databinding.ActivityModifyPromiseBinding;

public class make_promise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMakePromiseBinding binding = ActivityMakePromiseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.goBackInMakeProm.setOnClickListener(view -> {
            Toast.makeText(this, "약속 생성이 취소되었습니다.", Toast.LENGTH_SHORT).show();
            finish();
        });

        binding.complete.setOnClickListener(view -> {
            Toast.makeText(this, "약속 일정이 저장되었습니다. 승인 대기중...", Toast.LENGTH_SHORT).show();
            finish();
        });

        binding.viewFriends.setOnClickListener(view -> {
            startActivity(new Intent(this, friends_list.class));
        });
    }
}