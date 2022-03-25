package com.example.buildyourownadventure;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyMusicService extends Service {
    MediaPlayer player;
    int resId;
    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        resId = intent.getIntExtra("resId",resId);
        if(player != null){
            player.stop();
            player.release();
        }
        player = MediaPlayer.create(MyMusicService.this, resId);
        player.start();

        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();
        player.release();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}