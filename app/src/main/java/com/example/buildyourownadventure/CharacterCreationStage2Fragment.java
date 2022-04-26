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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterCreationStage2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationStage2Fragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String ARG_PARAM6 = "param6";

    // TODO: Rename and change types of parameters
    private Character c;

    public CharacterCreationStage2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment CharacterCreationStage2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterCreationStage2Fragment newInstance(Character c) {
        CharacterCreationStage2Fragment fragment = new CharacterCreationStage2Fragment();
        Bundle args = new Bundle();

        args.putSerializable(ARG_PARAM6, c);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            c = (Character) getArguments().getSerializable(ARG_PARAM6);
        }
    }
    Button buttonBack2;
    Button buttonNext2;
    EditText xp;
    EditText inspiration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_creation_stage2, container, false);
        buttonBack2 = view.findViewById(R.id.buttonBack2);
        buttonNext2 = view.findViewById(R.id.buttonNext2);
        xp = view.findViewById(R.id.editTextTextXP);
        inspiration = view.findViewById(R.id.editTextNumberInsperation);




        buttonBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage2Listener.backFromStage2();
            }
        });

        buttonNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage2Listener.toStage3();
            }
        });



        return view;
    }





    ICreateCharacterStage2Listener CreateCharacterStage2Listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ICreateCharacterStage2Listener) {
            CreateCharacterStage2Listener = (ICreateCharacterStage2Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ICreateCharacterStage2Listener");
        }
    }

    public interface ICreateCharacterStage2Listener {
        void backFromStage2();

        void toStage3();
    }
}