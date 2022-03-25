package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class roll_the_dice extends AppCompatActivity {

    TextView txt;
    Button btn;
    EditText getDie;
    EditText getSides;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_the_dice);

        //get input from num fields
        //getSides = findViewById(R.id.numSided);
        //getDie = findViewById(R.id.numDie);

        //initiate txt field and btn
        //txt = findViewById(R.id.rollResult);
        //btn = findViewById(R.id.rollDieBtn);

        //get values from input
        int numSides = Integer.parseInt(getSides.getText().toString());
        int numDie = Integer.parseInt(getDie.getText().toString());

        //Btn method for random
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();

                //TODO
                //create array based on num die
                int arr[];
                arr = new int[numDie];



                //set max for random
                int max = numSides + 1;
                int val = random.nextInt(max);
                val += 1;
                txt.setText(Integer.toString(val));


            }
        });
    }
}