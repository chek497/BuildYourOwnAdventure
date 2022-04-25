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
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";
    private static final String ARG_PARAM5 = "param5";

    // TODO: Rename and change types of parameters
    private String cName;
    private String cClass;
    private String cRace;
    private String cBackground;
    private int cLevel;

    public CharacterCreationStage2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharacterCreationStage2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterCreationStage2Fragment newInstance(String param1, String param2, String param3, String param4, int param5) {
        CharacterCreationStage2Fragment fragment = new CharacterCreationStage2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        args.putInt(ARG_PARAM5, param5);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cName = getArguments().getString(ARG_PARAM1);
            cClass = getArguments().getString(ARG_PARAM2);
            cRace = getArguments().getString(ARG_PARAM3);
            cBackground = getArguments().getString(ARG_PARAM4);
            cLevel = getArguments().getInt(ARG_PARAM5);
        }
    }
    Button buttonBack2;
    Button buttonNext2;
    EditText xp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_creation_stage2, container, false);
        buttonBack2 = view.findViewById(R.id.buttonBack2);
        buttonNext2 = view.findViewById(R.id.buttonNext2);
        xp = view.findViewById(R.id.editTextTextXP);

        //TEMP//
        xp.setText(cName);




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