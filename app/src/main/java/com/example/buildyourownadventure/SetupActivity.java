package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SetupActivity extends AppCompatActivity {

    final String TAG = "demo"; //for tag

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        Log.d(TAG, "onCreate: Setup"); //log successful launch
        setTitle("Setup");
    }
    public void onClick(View v){
        ConstraintLayout background =  findViewById(R.id.constraintlayoutID);
        TextView text =  findViewById(R.id.textView);
        TextView text2 =  findViewById(R.id.textView3);
        //change background images
        switch (v.getId()){
            case R.id.dragonfight:
                background.setBackgroundResource(R.drawable.dragonfight);
                text.setTextColor(Color.BLACK);
                text2.setTextColor(Color.BLACK);
                break;
            case R.id.snowymountains:
                background.setBackgroundResource(R.drawable.snowymountains);
                text.setTextColor(Color.BLACK);
                text2.setTextColor(Color.BLACK);
                break;
            case R.id.dungeon:
                background.setBackgroundResource(R.drawable.dungeon);
                text.setTextColor(Color.WHITE);
                text2.setTextColor(Color.WHITE);
                break;
            case R.id.field:
                background.setBackgroundResource(R.drawable.field);
                text.setTextColor(Color.BLACK);
                text2.setTextColor(Color.BLACK);
                break;
            case R.id.tavern:
                background.setBackgroundResource(R.drawable.tavern);
                text.setTextColor(Color.WHITE);
                text2.setTextColor(Color.WHITE);
                break;
            //Send user back to main activity when they press create game
            case R.id.creategame:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}