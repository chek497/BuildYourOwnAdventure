package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class DictionaryActivity extends AppCompatActivity {

    final String TAG = "demo"; //for tag

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        Log.d(TAG, "onCreate: Dictionary"); //log successful launch
        setTitle("Dictionary");
    }
}