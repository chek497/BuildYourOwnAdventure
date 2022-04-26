package com.example.buildyourownadventure;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterCreationStage10Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationStage10Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private Character c;

    public CharacterCreationStage10Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment CharacterCreationStage10Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterCreationStage10Fragment newInstance(Character c) {
        CharacterCreationStage10Fragment fragment = new CharacterCreationStage10Fragment();
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
    Button back;
    Button createCharacter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_creation_stage10, container, false);
        back = view.findViewById(R.id.buttonBackStage10);
        createCharacter = view.findViewById(R.id.buttonCreateStage10);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage10Listener.backFromStage10();
            }
        });

        createCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage10Listener.createCharacter(c);
            }
        });




        return view;
    }

    ICreateCharacterStage10Listener CreateCharacterStage10Listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ICreateCharacterStage10Listener) {
            CreateCharacterStage10Listener = (ICreateCharacterStage10Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ICreateCharacterStage1Listener");
        }
    }

    public interface ICreateCharacterStage10Listener{
        void backFromStage10();
        void createCharacter(Character c);
    }
}