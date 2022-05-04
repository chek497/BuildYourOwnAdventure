package com.example.buildyourownadventure;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.firestore.FirebaseFirestore;

public class ContactFragment extends Fragment {
    public static final String TAG = "demo";

    public ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    EditText nameValueContact;
    EditText emailValueContact;
    EditText subjectValue;
    EditText descriptionValue;
    Button submitButtonContact;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        if(getActivity() != null) { getActivity().setTitle("Contact Us"); }
        
        nameValueContact = view.findViewById(R.id.nameValueContact);
        emailValueContact = view.findViewById(R.id.emailValueContact);
        subjectValue = view.findViewById(R.id.subjectValue);
        descriptionValue = view.findViewById(R.id.descriptionValue);
        submitButtonContact = view.findViewById(R.id.submitButtonContact);

        submitButtonContact.setOnClickListener(viewSubmit -> {
            //Collect response values
            String name = String.valueOf(nameValueContact.getText());
            String email = String.valueOf(emailValueContact.getText());
            String subject = String.valueOf(subjectValue.getText());
            String description = String.valueOf(descriptionValue.getText());

            //Input validation for every field to be required
            if(name.isEmpty()) {
                Toast.makeText(getContext(), "Name is required", Toast.LENGTH_SHORT).show();
            } else if(email.isEmpty()) {
                Toast.makeText(getContext(), "Email is required", Toast.LENGTH_SHORT).show();
            } else if (subject.isEmpty()) {
                Toast.makeText(getContext(), "Subject is required", Toast.LENGTH_SHORT).show();
            } else if(description.isEmpty()) {
                Toast.makeText(getContext(), "Description is required", Toast.LENGTH_SHORT).show();
            } else {
                //Initialize FireBaseFirestoreDB instance object
                FirebaseFirestore db = FirebaseFirestore.getInstance();

                //Create new ContactFormResponse object to store response
                ContactFormResponse newResponse = new ContactFormResponse();
                newResponse.setName(name);
                newResponse.setEmail(email);
                newResponse.setSubject(subject);
                newResponse.setDescription(description);

                //Send contact form response to database
                //Document ID is automatically generated;
                db.collection("ContactFormResponses")
                        .add(newResponse)
                        .addOnSuccessListener(documentReference -> Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId()))
                        .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));
                //Send user back to dashboard fragment
                contactListener.endContact();
            }
        });
        return view;
    }

    IContactListener contactListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof IContactListener) {
            contactListener = (IContactListener) context;
        } else {
            throw new RuntimeException(context + "must implement IContactListener");
        }
    }

    public interface IContactListener{
        void endContact();
    }

}