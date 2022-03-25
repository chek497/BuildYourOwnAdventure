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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoginFragment.ILoginListener, RegisterFragment.IRegisterListener {
    //Purpose and todos. Updated: 2/18/2022
    //Landing screen, leads to other functions of the app.

    final String TAG = "demo"; //For Logging and Testing Purposes

    //Following keys for starting and identifying Fragments
    public static final String LOGIN_KEY = "LOGIN_KEY";
    public static final String REGISTER_KEY = "REGISTER_KEY";
    public static final String FAQ_KEY = "FAQ_KEY";
    public static final String SETTINGS_KEY = "SETTINGS_KEY";
    public static final String CONTACT_KEY = "CONTACT_KEY";
    public static final String DICE_KEY = "DICE_KEY";
    public static final String CALCULATOR_KEY = "CALCULATOR_KEY";
    public static final String LIBRARIES_KEY = "LIBRARIES_KEY";
    public static final String SOUNDS_KEY = "SOUNDS_KEY";


    //Temporary users ArrayList in place of Database
    ArrayList<User> users = new ArrayList<>();
    User admin = new User("Administrator_Account", "byoa", "1");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Home"); //log successful launch
        setTitle("Home");

        //Adding administrator credentials
        users.add(admin);

        //Starting LoginFragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.rootView, LoginFragment.newInstance(users), LOGIN_KEY)
                .commit();
    }

    @Override
    public void successfulLogin(User user) {
        Toast.makeText(this, "Successful Login. Welcome back " + user.getFullName() + "!", Toast.LENGTH_LONG)
                .show();

        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, NEXT_FRAGMENT.newInstance(), NEXT_FRAGMENT_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void unsuccessfulLogin() {
        Toast.makeText(this, "Unsuccessful Login. The email or password are invalid.", Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void startRegister(ArrayList<User> users) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, RegisterFragment.newInstance(users), REGISTER_KEY)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void registerUser(String firstName, String lastName, String email, String password) {
        User newUser = new User(firstName + " " + lastName, email, password);
        users.add(newUser);
        Bundle bundle = new Bundle();
        bundle.putSerializable(LOGIN_KEY, users);
        getSupportFragmentManager().findFragmentByTag(LOGIN_KEY).setArguments(bundle);
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelRegister() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void startFAQ() {
        /*
        Intent intentFAQ = new Intent(MainActivity.this, FaqActivity.class);
        startActivity(intentFAQ);
         */
    }

    @Override
    public void startSettings() {
        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, SettingsFragment.newInstance(null, null), SETTINGS_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void startContact() {
        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, ContactFragment.newInstance(null, null), CONTACT_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void startDice() {
        Intent intentDice = new Intent(MainActivity.this, roll_the_dice.class);
        startActivity(intentDice);
    }

    @Override
    public void startCalculator() {
        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, CalculatorFragment.newInstance(null, null), CALCULATOR_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void startLibraries() {
        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, LibrariesFragment.newInstance(null, null), LIBRARIES_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void startSounds() {
        Intent intentSounds = new Intent(MainActivity.this, BgMusicActivity.class);
        startActivity(intentSounds);
    }
}