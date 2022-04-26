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
 * Use the {@link CharacterCreationStage7Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationStage7Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private Character c;

    public CharacterCreationStage7Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment CharacterCreationStage7Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterCreationStage7Fragment newInstance(Character c) {
        CharacterCreationStage7Fragment fragment = new CharacterCreationStage7Fragment();
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
    Button backButton7;
    Button nextButton7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_creation_stage7, container, false);
        backButton7 = view.findViewById(R.id.buttonBack7);
        nextButton7 = view.findViewById(R.id.buttonNext7);

        backButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage7Listener.backFromStage7();
            }
        });
        nextButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage7Listener.toStage8(c);
            }
        });

        return view;
    }

    ICreateCharacterStage7Listener CreateCharacterStage7Listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ICreateCharacterStage7Listener) {
            CreateCharacterStage7Listener = (ICreateCharacterStage7Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ICreateCharacterStage1Listener");
        }
    }

    public interface ICreateCharacterStage7Listener{
        void backFromStage7();
        void toStage8(Character c);
    }
}