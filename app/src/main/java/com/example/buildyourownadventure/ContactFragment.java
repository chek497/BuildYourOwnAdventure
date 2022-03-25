package com.example.buildyourownadventure;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ContactFragment extends Fragment {

    public static final String CONTACT_KEY = "CONTACT_KEY";

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
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(CONTACT_KEY);
        }
    }

    EditText subjectValue;
    EditText descriptionValue;
    Button submitButtonContact;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        subjectValue = view.findViewById(R.id.subjectValue);
        descriptionValue = view.findViewById(R.id.descriptionValue);
        submitButtonContact = view.findViewById(R.id.submitButtonContact);

        String subject = String.valueOf(subjectValue.getText());
        String description = String.valueOf(descriptionValue.getText());

        submitButtonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                //SEND FORM USING OKHTTP3
                //SEND TO EMAIL OR ADD TO DATABASE

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
            throw new RuntimeException(context.toString() + "must implement IContactListener");
        }
    }

    public interface IContactListener{
        void endContact();
    }

}