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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class LoginFragment extends Fragment {

    private FirebaseAuth mAuth;
    final private String TAG = "demo";

    public LoginFragment() {
        // Required empty public constructor
    }
    public static final String USER_LIST_KEY = "USER_LIST_KEY";
    public static final String LOGIN_KEY = "LOGIN_KEY";

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    EditText emailValue;
    EditText passwordValue;
    Button loginButton;
    Button startRegisterButton;

    Button faqButton;
    Button contactButton;
    Button settingsButton;
    Button calcButton;
    Button diceButton;
    Button soundsButton;
    Button librariesButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        getActivity().setTitle("Home");

        emailValue = view.findViewById(R.id.emailValue);
        passwordValue = view.findViewById(R.id.passwordValue);
        loginButton = view.findViewById(R.id.loginButton);
        startRegisterButton = view.findViewById(R.id.startRegisterButton);

        faqButton = view.findViewById(R.id.faqButton);
        contactButton = view.findViewById(R.id.contactButton);
        settingsButton = view.findViewById(R.id.settingsButton);
        calcButton = view.findViewById(R.id.calcButton);
        diceButton = view.findViewById(R.id.diceButton);
        soundsButton = view.findViewById(R.id.soundsButton);
        librariesButton = view.findViewById(R.id.librariesButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailValue.getText().toString();
                String password = passwordValue.getText().toString();

                if (email.isEmpty()) {
                    Toast.makeText(getContext(), "Email is required", Toast.LENGTH_SHORT).show();
                } else if(password.isEmpty()) {
                    Toast.makeText(getContext(), "Password  is required", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth = FirebaseAuth.getInstance();
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        loginListener.successfulLogin();
                                        Log.d(TAG, "onComplete: Logged In Successfully");
                                        Log.d(TAG, "onComplete: " + mAuth.getCurrentUser().getUid());
                                    } else {
                                        String errorMessage = task.getException().getMessage();
                                        loginListener.unsuccessfulLogin(errorMessage);
                                        Log.d(TAG, "onComplete: Error");
                                        Log.d(TAG, "onComplete: " + task.getException().getMessage());
                                    }
                                }
                            });
                }
                /*
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(password)) {
                        loginListener.successfulLogin(users.get(i));
                    } else {
                        loginListener.unsuccessfulLogin();
                    }
                }
                 */
            }
        });

        startRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginListener.startRegister();
            }
        });

        faqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginListener.startFAQ();
            }
        });

        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginListener.startContact();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginListener.startSettings();
            }
        });

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginListener.startCalculator();
            }
        });

        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginListener.startDice();
            }
        });

        soundsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginListener.startSounds();
            }
        });

        librariesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginListener.startLibraries();
            }
        });

        return view;
    }

    ILoginListener loginListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ILoginListener) {
            loginListener = (ILoginListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement ILoginListener");
        }
    }

    public interface ILoginListener{
        void successfulLogin();
        void unsuccessfulLogin(String errorMessage);
        void startRegister();
        void startFAQ();
        void startSettings();
        void startContact();
        void startDice();
        void startCalculator();
        void startLibraries();
        void startSounds();
    }

}