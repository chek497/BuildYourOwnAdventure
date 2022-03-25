package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class roll_the_dice extends AppCompatActivity {

    
    private ImageView d4Die;
    private ImageView d6Die;
    private ImageView d8Die;
    private ImageView d10Die;
    private ImageView d12Die;
    private ImageView d20Die;
    private TextView tvResult;
    private TextView tvHist1;
    private TextView tvHist2;
    private TextView tvHist3;
    private TextView tvHist4;
    private TextView tvHist5;
    private int count = 2;
    private int resultCount = 0;
    private TextView tvMinus;
    private TextView tvPlus;
    private Button resetButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_the_dice);
        setTitle("Dice");

        //result and die imageviews
        tvResult = (TextView)findViewById(R.id.dResultView);
        d4Die = (ImageView) findViewById(R.id.imageViewD4);
        d6Die = (ImageView) findViewById(R.id.imageViewD6);
        d8Die = (ImageView) findViewById(R.id.imageViewD8);
        d10Die = (ImageView) findViewById(R.id.imageViewD10);
        d12Die = (ImageView) findViewById(R.id.imageViewD12);
        d20Die = (ImageView) findViewById(R.id.imageViewD20);

        //roll history
        tvHist1 = (TextView)findViewById(R.id.textViewHistory1);
        tvHist2 = (TextView)findViewById(R.id.textViewHistory2);
        tvHist3 = (TextView)findViewById(R.id.textViewHistory3);
        tvHist4 = (TextView)findViewById(R.id.textViewHistory4);
        tvHist5 = (TextView)findViewById(R.id.textViewHistory5);

        //plus or minus
        tvMinus = (TextView)findViewById(R.id.dResultMinus);
        tvPlus = (TextView)findViewById(R.id.dResultPlus);

        //rest button
        resetButton =(Button)findViewById(R.id.resetCounter);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultCount = 0;
                String string = String.valueOf(resultCount);
                tvResult.setText(string);
            }
        });

        //onclick for D# die
        d4Die.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                rollDie(4);
            }
        });

        d6Die.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                rollDie(6);
            }
        });

        d8Die.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                rollDie(8);
            }
        });

        d10Die.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                rollDie(10);
            }
        });

        d12Die.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                rollDie(12);
            }
        });

        d20Die.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                rollDie(20);
            }
        });

        tvMinus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int plus = 0;
                plusMinus(plus);
            }
        });

        tvPlus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int plus = 1;
                plusMinus(plus);
            }
        });


    }

    //method to add or subtract from the result window
    public void plusMinus(int plus){
        if(plus == 0){
            resultCount--;
        }

        if(plus == 1){
            resultCount++;
        }

        String resultPlusMinus = String.valueOf(resultCount);
        tvResult.setText(resultPlusMinus);
    }


    //roll the dice
    public void rollDie(int max){
        Random rand = new Random();
        int dieResult = rand.nextInt(max) + 1;

        String history = String.valueOf(dieResult);
        dieHistory(history);

        resultCount = resultCount + dieResult;
        String stringResult = String.valueOf(resultCount);
        tvResult.setText(stringResult);
    }



    //set die history
    public void dieHistory(String s){

        if(count == 6){
            count = 2;
            tvHist1.setText("");
            tvHist2.setText("");
            tvHist3.setText("");
            tvHist4.setText("");
            tvHist5.setText("");
        }

        String dieResult = s;

        switch (count) {
            //imageview 1 for roll history is not displaying, skip to 2
            case 1:
                tvHist1.setText("");
                break;
            case 2:
                tvHist2.setText("You rolled a " + s);
                break;
            case 3:
                tvHist3.setText("You rolled a " + s);
                break;
            case 4:
                tvHist4.setText("You rolled a " + s);
                break;
            case 5:
                tvHist5.setText("You rolled a " + s);
                break;
        }
        count++;

    }























}

