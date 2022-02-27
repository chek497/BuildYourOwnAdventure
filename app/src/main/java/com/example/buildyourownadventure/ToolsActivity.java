package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ToolsActivity extends AppCompatActivity {

    final String TAG = "demo"; //for tag

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        Log.d(TAG, "onCreate: Tools"); //log successful launch
        setTitle("Tools");

        //Go to dice tool button
        Button diceBtn = findViewById(R.id.to_dice_tool);
        diceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiceTool();
            }
        });




        //Button
        //get button
        Button btn = findViewById(R.id.rollDiceBtn);
        TextView tv = findViewById(R.id.txtRoll);
        int maxInput = 0;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 1;
                int max = 20;


                Random rand = new Random();
                int int_random = rand.nextInt((max - min) + 1) + min;
                tv.setText(Integer.toString(int_random));

            }
        });
    }

    public void openDiceTool(){
        Intent diceIntent = new Intent(this, roll_the_dice.class);
        startActivity(diceIntent);
    }
}