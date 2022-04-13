package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class BgMusicActivity extends AppCompatActivity {

    final String TAG = "demo"; //for tag
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bgmusic);
        listView = findViewById(R.id.listview);

        Log.d(TAG, "onCreate: Setup"); //log successful launch
        setTitle("Background Music/Sounds");

        ArrayList<String> arrayList = new ArrayList<>();
        //Get all files in raw directory
        Field[] songs = R.raw.class.getFields();
        //add songs to list
        for (int i = 0; i < songs.length; i++) {
            arrayList.add(songs[i].getName());
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_items, android.R.id.text1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                Log.d(TAG, "Clicked");
                Intent intent = new Intent(BgMusicActivity.this, MyMusicService.class);
                int resId = getResources().getIdentifier(arrayList.get(i), "raw", getPackageName());
                intent.putExtra("resId", resId);
                startService(intent);

            }
        });


    }

    public void onStop(View v) {
        Intent intent = new Intent(BgMusicActivity.this, MyMusicService.class);
        stopService(intent);
    }
}