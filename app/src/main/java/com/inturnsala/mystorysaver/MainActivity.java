package com.inturnsala.mystorysaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.inturnsala.mystorysaver.databinding.ActivityMainBinding;

public class  MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.whatApp.setOnClickListener(v -> {
          startActivity(new Intent(this,WhatsappActivity.class));

        });
    }
}