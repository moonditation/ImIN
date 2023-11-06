package com.example.projectlayoutframe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.projectlayoutframe.databinding.ActivityFriendsListBinding;

public class friends_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFriendsListBinding binding = ActivityFriendsListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.goBackInMakeProm.setOnClickListener(view -> {
            Toast.makeText(this, "약속 생성화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}