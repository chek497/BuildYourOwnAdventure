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
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterCreationStage3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationStage3Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private Character c;

    public CharacterCreationStage3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment CharacterCreationStage3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterCreationStage3Fragment newInstance(Character c) {
        CharacterCreationStage3Fragment fragment = new CharacterCreationStage3Fragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, c);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            c = (Character) getArguments().getSerializable(ARG_PARAM1);

        }
    }
    Button buttonBack3;
    Button buttonNext3;
    EditText strength1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_creation_stage3, container, false);

        buttonBack3 = view.findViewById(R.id.buttonBack3);
        buttonNext3 = view.findViewById(R.id.buttonNext3);
        strength1 = view.findViewById(R.id.editTextNumberStrength1);



        buttonBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage3Listener.backFromStage3();
            }
        });

        buttonNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateCharacterStage3Listener.toStage4(c);
            }
        });


        return view;
    }





    ICreateCharacterStage3Listener CreateCharacterStage3Listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ICreateCharacterStage3Listener) {
            CreateCharacterStage3Listener = (ICreateCharacterStage3Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ICreateCharacterStage1Listener");
        }
    }

    public interface ICreateCharacterStage3Listener{
        void backFromStage3();
        void toStage4(Character c);
    }
}