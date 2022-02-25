package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class FaqActivity extends AppCompatActivity {

    final String TAG = "demo"; //for tag

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        Log.d(TAG, "onCreate: FAQ"); //log successful launch
        setTitle("FAQ/Contact Us");
    }
    public void onClick(View v){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}