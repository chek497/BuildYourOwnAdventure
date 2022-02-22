package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ToolsActivity extends AppCompatActivity {

    final String TAG = "demo"; //for tag

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        Log.d(TAG, "onCreate: Tools"); //log successful launch
        setTitle("Tools");
    }
}