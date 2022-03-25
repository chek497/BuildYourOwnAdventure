package com.example.buildyourownadventure;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RegisterFragment extends Fragment {

    public static final String REGISTER_KEY = "REGISTER_KEY";
    public ArrayList<User> users = new ArrayList<>();

    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment newInstance(ArrayList<User> users) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putSerializable(REGISTER_KEY, users);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            users = (ArrayList<User>) getArguments().getSerializable(REGISTER_KEY);
        }
    }

    EditText firstNameValue;
    EditText lastNameValue;
    EditText emailRegisterValue;
    EditText passwordRegisterValue;
    Button registerButton;
    Button backToLoginButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        firstNameValue = view.findViewById(R.id.firstNameValue);
        lastNameValue = view.findViewById(R.id.lastNameValue);
        emailRegisterValue = view.findViewById(R.id.emailRegisterValue);
        passwordRegisterValue = view.findViewById(R.id.passwordRegisterValue);
        registerButton = view.findViewById(R.id.registerButton);
        backToLoginButton = view.findViewById(R.id.backToLoginButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = firstNameValue.getText().toString();
                String lastName = lastNameValue.getText().toString();
                String email = emailRegisterValue.getText().toString();
                String password = passwordRegisterValue.getText().toString();

                if (firstName.isEmpty()) {
                    Toast.makeText(getContext(), "Please enter your first name.", Toast.LENGTH_SHORT)
                            .show();
                } else if(lastName.isEmpty()) {
                    Toast.makeText(getContext(), "Please enter your last name.", Toast.LENGTH_SHORT)
                            .show();
                } else if(email.isEmpty()) {
                    Toast.makeText(getContext(), "Please enter your email.", Toast.LENGTH_SHORT)
                            .show();
                } else if(password.isEmpty()) {
                    Toast.makeText(getContext(), "Please enter a password.", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(getContext(), "Account Successfully Created", Toast.LENGTH_SHORT)
                            .show();
                    registerListener.registerUser(firstName, lastName, email, password);
                }

                /*
                //Checking to see if account is already created with that email
                //Does not work yet

                Log.d("TEST", "Users: " + users.toString());
                Log.d("TEST", "Number of users: " + users.size());
                Log.d("TEST", "User: " + users.get(0).toString());
                Log.d("TEST", "Email: " + users.get(0).getEmail());
                Log.d("TEST", "Registering Email: " + email);

                for (int i = 0; i < users.size(); i++) {
                    if (email.equals(users.get(i).getEmail())) {
                        Log.d("TEST", "Inside IF");

                        Toast.makeText(getContext(), "Error. There is already an account associated with that email address.", Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        Log.d("TEST", "Inside ELSE");

                        registerListener.registerUser(firstName, lastName, email, password);
                    }
                }*/
            }
        });

        backToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerListener.cancelRegister();
            }
        });

        return view;
    }

    IRegisterListener registerListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof IRegisterListener) {
            registerListener = (IRegisterListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement IRegisterListener");
        }
    }

    public interface IRegisterListener{
        void registerUser(String firstName, String lastName, String email, String password);
        void cancelRegister();
    }

}