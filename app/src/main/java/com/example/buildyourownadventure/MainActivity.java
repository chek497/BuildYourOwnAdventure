package com.example.buildyourownadventure;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements LoginFragment.ILoginListener, RegisterFragment.IRegisterListener,
        DashboardFragment.IDashboardListener, ContactFragment.IContactListener,
        CharacterFragment.ICreateCharacterListener, CalculatorFragment.ICalculatorListener {


    //FirebaseAuth object variable
    FirebaseAuth mAuth;

    final String TAG = "demo"; //For Logging and Testing Purposes

    //Following keys for starting and identifying Fragments
    public static final String LOGIN_KEY = "LOGIN_KEY";
    public static final String USER_KEY = "USER_KEY";
    public static final String REGISTER_KEY = "REGISTER_KEY";
    public static final String CONTACT_KEY = "CONTACT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Home"); //Log successful launch

        //Initialize FirebaseAuth instance object
        mAuth = FirebaseAuth.getInstance();

        //If there is not a current user authenticated, send Login Fragment
        //If there is a user authenticated, send Dashboard fragment
        if(mAuth.getCurrentUser() == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.rootView, new LoginFragment())
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.rootView, new DashboardFragment())
                    .commit();
        }
    }



    @Override
    public void successfulLogin() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, DashboardFragment.newInstance(), USER_KEY)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void unsuccessfulLogin(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void startRegister() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, RegisterFragment.newInstance(), REGISTER_KEY)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void successfulRegister() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new LoginFragment())
                .commit();
    }

    @Override
    public void unsuccessfulRegister(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
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
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, ContactFragment.newInstance(), CONTACT_KEY)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void runOnUIThreadDashboardSetDisplayName(Runnable runnable) {
        runnable.run();
    }

    @Override
    public void startAIDungeon() {
        /*old code
        Intent intent = new Intent(this, AiDungeon.class);
        startActivity(intent);
         */
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://play.aidungeon.io/"));
        startActivity(intent);

    }

    @Override
    public void startGameSetup() {
        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, GameSetupFragment.newInstance(null, null), GAME_SETUP_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void startNotes() {
        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, NotesFragment.newInstance(null, null), NOTES_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void startCharacters() {

        Intent intent = new Intent(this, CharacterActivity.class);
        startActivity(intent);

    }

    @Override
    public void startDice() {
        Intent intentDice = new Intent(MainActivity.this, roll_the_dice.class);
        startActivity(intentDice);
    }

    @Override
    public void startCalculator() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, CalculatorFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void startLibraries() {
        Intent intentLibraries = new Intent(MainActivity.this, DndLibraries.class);
        startActivity(intentLibraries);
    }

    @Override
    public void startGridMap() {
        //Added in branch RoutingHotFix
        //Please check @Kareem
        Intent intentGrid = new Intent(MainActivity.this, GridMapActivity.class);
        startActivity(intentGrid);
    }

    @Override
    public void startSounds() {
        Intent intentSounds = new Intent(MainActivity.this, BgMusicActivity.class);
        startActivity(intentSounds);
    }

    @Override
    public void startTutorial() {
        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, LibrariesFragment.newInstance(null, null), TUTORIAL_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void logout() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, LoginFragment.newInstance(), LOGIN_KEY)
                .commit();
    }

    @Override
    public void endContact() {
        Toast.makeText(this, "Thank you for your feedback!", Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void newCharacter() {
        //TODO
        //Added in branch RoutingHotFix
        //Please check @Brandon
    }

    @Override
    public void backToCharacterActivity() {
        //TODO
        //Added in branch RoutingHotFix
        //Please check @Brandon
    }

    @Override
    public void backToDashboard() {
        getSupportFragmentManager().popBackStack();
    }
}