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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterCreationStage1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationStage1Fragment extends Fragment {

    ArrayList<Character> character = new ArrayList<>();
    Character newC = new Character();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CharacterCreationStage1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharacterCreationStage1.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterCreationStage1Fragment newInstance(String param1, String param2) {
        CharacterCreationStage1Fragment fragment = new CharacterCreationStage1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    Button buttonBack;
    Button buttonNext1;
    EditText characterName;
    TextView subraceText;
    RadioGroup classNameGroup;
    RadioButton className;
    RadioButton characterRace;
    SeekBar characterLevel;
    EditText characterBackground;
    RadioGroup characterRaceGroup;
    Switch subrace;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_creation_stage1, container, false);

        buttonBack = view.findViewById(R.id.buttonBack1);
        buttonNext1 = view.findViewById(R.id.buttonNext1);
        characterName = view.findViewById(R.id.editTextTextPersonName);
        classNameGroup = view.findViewById(R.id.RadioGroupClasses);
        characterLevel = view.findViewById(R.id.seekBar);
        characterBackground = view.findViewById(R.id.editTextTextPersonName2);
        characterRaceGroup = view.findViewById(R.id.radioGroupRace);

        subraceText = view.findViewById(R.id.textView69);

        subrace = view.findViewById(R.id.switchSubRace);
        subrace.setVisibility(View.INVISIBLE);




        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateCharacterStage1Listener.backFromStage1();
            }
        });


        classNameGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int groupint = classNameGroup.getCheckedRadioButtonId();
                className = view.findViewById(groupint);
            }
        });


        characterRaceGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int groupint2 = characterRaceGroup.getCheckedRadioButtonId();
                characterRace = view.findViewById(groupint2);

                // Determine SubRace //
                subrace.setVisibility(View.VISIBLE);

                subraceText.setText("Acolyte subrace?");



            }
        });

        subrace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newC.setSubRace("Acolyte");
            }
        });


        buttonNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                newC.setName(characterName.getText().toString());
                newC.setCharacterClass(className.getText().toString());
                newC.setRace(characterRace.getText().toString());
                newC.setBackground(characterBackground.getText().toString());
                newC.setLevel(characterLevel.getProgress());

                CreateCharacterStage1Listener.toStage2(newC);
            }
        });




        return view;
    }


    ICreateCharacterStage1Listener CreateCharacterStage1Listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ICreateCharacterStage1Listener) {
            CreateCharacterStage1Listener = (ICreateCharacterStage1Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ICreateCharacterStage1Listener");
        }
    }


    public interface ICreateCharacterStage1Listener{
        void backFromStage1();
        void toStage2(Character c);
    }
}