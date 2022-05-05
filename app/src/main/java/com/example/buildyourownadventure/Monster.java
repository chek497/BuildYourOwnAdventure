package com.example.buildyourownadventure;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Monster extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libraries);
        setTitle(intent.getStringExtra("monster"));
    }
}
