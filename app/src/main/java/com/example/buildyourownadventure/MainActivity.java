package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Purpose and todos. Updated: 2/18/2022
    //Landing screen, leads to other functions of the app.
    //todo link to each other fragment
    //todo add radio button to link to Dictionary

    final String TAG = "demo"; //for tag

    TextView textViewDefault, textViewDescriptionOutput;
    int choiceSelected; //default zero
    ConstraintLayout rootView;
    RadioGroup rgCol1, rgCol2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonChangeActivity).setOnClickListener(this);
        textViewDefault = findViewById(R.id.textViewChoiceLabel);
        textViewDescriptionOutput = findViewById(R.id.textViewDescriptionOutput);
        rgCol1 = findViewById(R.id.radioGroupWorkspaceChoiceCol1);
        rgCol2 = findViewById(R.id.radioGroupWorkspaceChoiceCol2);
        rgCol1.setOnCheckedChangeListener(col1Listener);
        rgCol2.setOnCheckedChangeListener(col2Listener);
        rootView = findViewById(R.id.rootView);

        Log.d(TAG, "onCreate: Home"); //log successful launch
        setTitle("Home");

    }

    RadioGroup.OnCheckedChangeListener col1Listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Log.d(TAG, "onCheckedChanged: col1" + checkedId);
            if (checkedId != -1) { //if the user has selected anything. might not be necessary?
                rgCol2.setOnCheckedChangeListener(null);
                rgCol2.clearCheck(); //clearCheck activates the listener, so we turn it off.
                rgCol2.setOnCheckedChangeListener(col2Listener);
            }
            if (checkedId == R.id.radioButtonHubActivity) {
                choiceSelected = -1;
            } else if (checkedId == R.id.radioButtonMainActivity) {
                choiceSelected = 1;
            } else if (checkedId == R.id.radioButtonSecondActivity) {
                choiceSelected = 2;
            } else if (checkedId == R.id.radioButtonThirdActivity) {
                choiceSelected = 3;
            }
        }
    };

    RadioGroup.OnCheckedChangeListener col2Listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Log.d(TAG, "onCheckedChanged: col2" + checkedId);
            if (checkedId != -1) { //if the user has selected anything. might not be necessary?
                rgCol1.setOnCheckedChangeListener(null);
                rgCol1.clearCheck(); //clearCheck activates the listener, so we turn it off.
                rgCol1.setOnCheckedChangeListener(col1Listener);
            }
            if (checkedId == R.id.radioButtonFourthActivity) {
                choiceSelected = 4;
            } else if (checkedId == R.id.radioButtonFifthActivity) {
                choiceSelected = 5;
            } else if (checkedId == R.id.radioButtonSixthActivity) {
                choiceSelected = 6;
            } else if (checkedId == R.id.radioButtonSeventhActivity) {
                choiceSelected = 7;
            }

        }
    };

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonChangeActivity) {
            Log.d(TAG, "OnChangeActivity: ");
//                    int checkedId = radioGroupWorkspaceChoice.getCheckedRadioButtonId();
            //checkedId gets the RadioButton Id directly instead of having to set it up in
            //a radioGroup listener. But it doesn't like when I do that with a switch.
            //Still works with if/else if statements, so if the only thing your listener
            //does is set a choiceSelected value, do that instead of switches.
            switch (choiceSelected) {
                case -1: //0 is default
                    Toast.makeText(this, "You're already home.", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                    startActivity(intent);
                    break;
                case 2:
                    Intent intent2 = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent2);
                    break;
                case 3:
                    Intent intent3 = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(intent3);
                    break;
                case 4:
                    Intent intent4 = new Intent(MainActivity.this, FaqActivity.class);
                    startActivity(intent4);
                    break;
                case 5:
                    Intent intent5 = new Intent(MainActivity.this, SetupActivity.class);
                    startActivity(intent5);
                    break;
                case 6:
                    Intent intent6 = new Intent(MainActivity.this, ToolsActivity.class);
                    startActivity(intent6);
                    break;
                case 7:
                    Intent intent7 = new Intent(MainActivity.this, DictionaryActivity.class);
                    startActivity(intent7);
                    break;
                default:
                    Toast.makeText(this, "Select an Activity.", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}