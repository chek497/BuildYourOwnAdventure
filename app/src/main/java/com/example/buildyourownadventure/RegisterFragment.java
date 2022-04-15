package com.example.buildyourownadventure;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RegisterFragment extends Fragment {
    private FirebaseAuth mAuth;
    final private String TAG = "demo";

    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    EditText firstNameValue;
    EditText lastNameValue;
    EditText emailRegisterValue;
    EditText passwordRegisterValue;
    Button registerButton;
    Button backToLoginButton;

    //Thread handlers
    ExecutorService threadPool;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        getActivity().setTitle("Register");

        firstNameValue = view.findViewById(R.id.firstNameValue);
        lastNameValue = view.findViewById(R.id.lastNameValue);
        emailRegisterValue = view.findViewById(R.id.emailRegisterValue);
        passwordRegisterValue = view.findViewById(R.id.passwordRegisterValue);
        registerButton = view.findViewById(R.id.registerButton);
        backToLoginButton = view.findViewById(R.id.backToLoginButton);

        threadPool = Executors.newFixedThreadPool(4);

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
                    mAuth = FirebaseAuth.getInstance();

                    String name = firstName + " " + lastName;

                    //Create user with Email and Password
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()) {
                                        //Update user profile with name
                                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                .setDisplayName(name)
                                                .build();
                                        mAuth.getCurrentUser().updateProfile(profileUpdates)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Log.d(TAG, "User profile updated.");
                                                        }
                                                    }
                                                });
                                        Toast.makeText(getActivity(), "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                        registerListener.successfulRegister();
                                        Log.d(TAG, "onComplete: Registered Successfully");

                                        Map<String, String> user = new HashMap<>();
                                        user.put("name", name);
                                        user.put("userId", mAuth.getCurrentUser().getUid());

                                        FirebaseFirestore db = FirebaseFirestore.getInstance();
                                        db.collection("users").document(name)
                                                .set(user)
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        Log.d(TAG, "DocumentSnapshot successfully written!");
                                                    }
                                                })
                                                .addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Log.w(TAG, "Error writing document", e);
                                                    }
                                                });
                                    } else {
                                        String errorMessage = task.getException().getMessage();
                                        registerListener.unsuccessfulRegister(errorMessage);
                                        Log.d(TAG, "onComplete: Error");
                                    }
                                }
                            });
                }
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
        void successfulRegister();
        void unsuccessfulRegister(String errorMessage);
        void cancelRegister();
    }

}