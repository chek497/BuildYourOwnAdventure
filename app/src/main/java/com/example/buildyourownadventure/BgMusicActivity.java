package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class BgMusicActivity extends AppCompatActivity {

    final String TAG = "demo"; //for tag
    ListView listView;
    MediaPlayer player;
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
        for(int i = 0; i<songs.length; i++){
            arrayList.add(songs[i].getName());
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_items, android.R.id.text1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l){
                //If music is playing stop it
                if(player != null){
                    player.release();
                }
                //get resource id of sound file
                int resId = getResources().getIdentifier(arrayList.get(i), "raw", getPackageName());
                //play sound file using resource id
                player = MediaPlayer.create(BgMusicActivity.this,resId);
                player.start();
                Toast.makeText(BgMusicActivity.this, "Playing " + arrayList.get(i), Toast.LENGTH_SHORT).show();

            }
        });


    }
    public void onStop(View v){
        if(player != null) {
            player.pause();
            Toast.makeText(BgMusicActivity.this, "Stopped Sound", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(BgMusicActivity.this, "Nothing is currently being played", Toast.LENGTH_SHORT).show();
        }
    }
    public void onResume(View v){
        if(player != null) {
            player.start();
            Toast.makeText(BgMusicActivity.this, "Resumed Sound", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(BgMusicActivity.this, "Nothing is currently being played", Toast.LENGTH_SHORT).show();
        }
    }


}