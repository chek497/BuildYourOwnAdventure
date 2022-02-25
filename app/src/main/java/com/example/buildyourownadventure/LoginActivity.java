package com.example.buildyourownadventure;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements LoginFragment.ILoginListener, RegisterFragment.IRegisterListener {

    public static final String LOGIN_KEY = "LOGIN_KEY";
    public static final String REGISTER_KEY = "REGISTER_KEY";

    ArrayList<User> users = new ArrayList<>();
    User admin = new User("Administrator_Account", "byoa", "1");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users.add(admin);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer, LoginFragment.newInstance(users), LOGIN_KEY)
                .commit();
    }

    @Override
    public void successfulLogin(User user) {
        Toast.makeText(this, "Successful Login. Welcome to BYOA!", Toast.LENGTH_LONG)
                .show();

        /*

        TO DO -> Should start next Fragment

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, NEXT_FRAGMENT.newInstance(), NEXT_FRAGMENT_KEY)
                .addToBackStack(null)
                .commit();

         */
    }

    @Override
    public void unsuccessfulLogin() {
        Toast.makeText(this, "Unsuccessful Login. The email and password you entered do not belong to a valid account.", Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void startRegister(ArrayList<User> users) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, RegisterFragment.newInstance(users), REGISTER_KEY)
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

        //Toast.makeText(this, "New account has been registered!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void cancelRegister() {
        getSupportFragmentManager().popBackStack();
    }
}