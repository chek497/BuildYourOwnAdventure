package com.example.buildyourownadventure;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterCreationStage5Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationStage5Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private Character c;

    public CharacterCreationStage5Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment CharacterCreationStage5Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterCreationStage5Fragment newInstance(Character c) {
        CharacterCreationStage5Fragment fragment = new CharacterCreationStage5Fragment();
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
    Button buttonBack5;
    Button buttonNext5;

    RadioGroup skillGroup;

    RadioButton skillButton;
    RadioButton skillButton2;

    RadioButton acrobatics;
    RadioButton animalHandling;
    RadioButton arcana;
    RadioButton athletics;
    RadioButton deception;
    RadioButton intimidation;
    RadioButton history;
    RadioButton insight;
    RadioButton investigation;
    RadioButton medicine;
    RadioButton nature;
    RadioButton perception;
    RadioButton performance;
    RadioButton persuasion;
    RadioButton religion;
    RadioButton sleightOfHand;
    RadioButton stealth;
    RadioButton survival;

    TextView selection;

    int numSkills;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_creation_stage5, container, false);

        buttonBack5 = view.findViewById(R.id.buttonBack5);
        buttonNext5 = view.findViewById(R.id.buttonNext5);

        selection = view.findViewById(R.id.textView43);

        skillGroup = view.findViewById(R.id.RadioGroupSkills);

        intimidation = view.findViewById(R.id.radioButtonIntimidation);
        history = view.findViewById(R.id.radioButtonHistory);
        perception = view.findViewById(R.id.radioButton12);
        acrobatics = view.findViewById(R.id.radioButton);
        animalHandling = view.findViewById(R.id.radioButton2);
        arcana = view.findViewById(R.id.radioButton3);
        athletics = view.findViewById(R.id.radioButton4);
        deception = view.findViewById(R.id.radioButton5);
        insight = view.findViewById(R.id.radioButton7);
        investigation = view.findViewById(R.id.radioButton9);
        medicine = view.findViewById(R.id.radioButton10);
        nature = view.findViewById(R.id.radioButton11);
        perception = view.findViewById(R.id.radioButton12);
        performance = view.findViewById(R.id.radioButton22);
        persuasion = view.findViewById(R.id.radioButton23);
        religion = view.findViewById(R.id.radioButton25);
        sleightOfHand = view.findViewById(R.id.radioButton24);
        stealth = view.findViewById(R.id.radioButton26);
        survival = view.findViewById(R.id.radioButton27);


        numSkills = 0;




        if(c.getRace().contains("Half-Orc")){
            intimidation.setChecked(true);
        }else if (c.getRace().contains("Dwarf")) {
            // This is conditional in if the dwarf is doing an intelligence check related to stonework, if so add double proficiency bonus //
            history.setChecked(true);
        }else if(c.getRace().contains("Half-Elf")) {
            //Skill Versatility: You gain proficiency in two Skills of your choice.//
            numSkills = numSkills +2;
        }else if (c.getRace().contains("Elf")){
            // Keen Senses //
            perception.setChecked(true);
        }


        if(c.getCharacterClass().contains("Monk")){

            // If the specified class does not have access to these skills they will be set to invisible. //

            animalHandling.setVisibility(View.INVISIBLE);
            arcana.setVisibility(View.INVISIBLE);
            deception.setVisibility(View.INVISIBLE);
            intimidation.setVisibility(View.INVISIBLE);
            investigation.setVisibility(View.INVISIBLE);
            medicine.setVisibility(View.INVISIBLE);
            nature.setVisibility(View.INVISIBLE);
            perception.setVisibility(View.INVISIBLE);
            performance.setVisibility(View.INVISIBLE);
            persuasion.setVisibility(View.INVISIBLE);
            sleightOfHand.setVisibility(View.INVISIBLE);
            survival.setVisibility(View.INVISIBLE);

            numSkills = numSkills +2;

        }else if (c.getCharacterClass().contains("Barbar")){
            acrobatics.setVisibility(View.INVISIBLE);
            arcana.setVisibility(View.INVISIBLE);
            deception.setVisibility(View.INVISIBLE);
            history.setVisibility(View.INVISIBLE);
            insight.setVisibility(View.INVISIBLE);
            investigation.setVisibility(View.INVISIBLE);
            medicine.setVisibility(View.INVISIBLE);
            performance.setVisibility(View.INVISIBLE);
            persuasion.setVisibility(View.INVISIBLE);
            religion.setVisibility(View.INVISIBLE);
            sleightOfHand.setVisibility(View.INVISIBLE);
            stealth.setVisibility(View.INVISIBLE);

            numSkills = numSkills +2;

        }else if (c.getCharacterClass().contains("Bard")){

            numSkills = numSkills +3;

        }else if (c.getCharacterClass().contains("Cleric")){
            acrobatics.setVisibility(View.INVISIBLE);
            animalHandling.setVisibility(View.INVISIBLE);
            arcana.setVisibility(View.INVISIBLE);
            athletics.setVisibility(View.INVISIBLE);
            deception.setVisibility(View.INVISIBLE);
            intimidation.setVisibility(View.INVISIBLE);
            investigation.setVisibility(View.INVISIBLE);
            nature.setVisibility(View.INVISIBLE);
            perception.setVisibility(View.INVISIBLE);
            performance.setVisibility(View.INVISIBLE);
            sleightOfHand.setVisibility(View.INVISIBLE);
            stealth.setVisibility(View.INVISIBLE);
            survival.setVisibility(View.INVISIBLE);

            numSkills = numSkills +2;

        }else if (c.getCharacterClass().contains("Druid")){
            acrobatics.setVisibility(View.INVISIBLE);
            athletics.setVisibility(View.INVISIBLE);
            deception.setVisibility(View.INVISIBLE);
            history.setVisibility(View.INVISIBLE);
            intimidation.setVisibility(View.INVISIBLE);
            investigation.setVisibility(View.INVISIBLE);
            performance.setVisibility(View.INVISIBLE);
            persuasion.setVisibility(View.INVISIBLE);
            sleightOfHand.setVisibility(View.INVISIBLE);
            stealth.setVisibility(View.INVISIBLE);

            numSkills = numSkills +2;

        }else if (c.getCharacterClass().contains("Fighter")){
            arcana.setVisibility(View.INVISIBLE);
            deception.setVisibility(View.INVISIBLE);
            investigation.setVisibility(View.INVISIBLE);
            medicine.setVisibility(View.INVISIBLE);
            nature.setVisibility(View.INVISIBLE);
            performance.setVisibility(View.INVISIBLE);
            persuasion.setVisibility(View.INVISIBLE);
            religion.setVisibility(View.INVISIBLE);
            sleightOfHand.setVisibility(View.INVISIBLE);
            stealth.setVisibility(View.INVISIBLE);

            numSkills = numSkills +2;

        }else if (c.getCharacterClass().contains("Paladin")){
            acrobatics.setVisibility(View.INVISIBLE);
            animalHandling.setVisibility(View.INVISIBLE);
            arcana.setVisibility(View.INVISIBLE);
            deception.setVisibility(View.INVISIBLE);
            history.setVisibility(View.INVISIBLE);
            investigation.setVisibility(View.INVISIBLE);
            nature.setVisibility(View.INVISIBLE);
            perception.setVisibility(View.INVISIBLE);
            performance.setVisibility(View.INVISIBLE);
            sleightOfHand.setVisibility(View.INVISIBLE);
            stealth.setVisibility(View.INVISIBLE);
            survival.setVisibility(View.INVISIBLE);

            numSkills = numSkills +2;

        }else if (c.getCharacterClass().contains("Ranger")){
            acrobatics.setVisibility(View.INVISIBLE);
            arcana.setVisibility(View.INVISIBLE);
            deception.setVisibility(View.INVISIBLE);
            history.setVisibility(View.INVISIBLE);
            intimidation.setVisibility(View.INVISIBLE);
            medicine.setVisibility(View.INVISIBLE);
            performance.setVisibility(View.INVISIBLE);
            persuasion.setVisibility(View.INVISIBLE);
            religion.setVisibility(View.INVISIBLE);
            sleightOfHand.setVisibility(View.INVISIBLE);

            numSkills = numSkills +3;

        }else if (c.getCharacterClass().contains("Rogue")){
            animalHandling.setVisibility(View.INVISIBLE);
            arcana.setVisibility(View.INVISIBLE);
            history.setVisibility(View.INVISIBLE);
            medicine.setVisibility(View.INVISIBLE);
            nature.setVisibility(View.INVISIBLE);
            religion.setVisibility(View.INVISIBLE);
            survival.setVisibility(View.INVISIBLE);

            numSkills = numSkills +4;

        }else if (c.getCharacterClass().contains("Sorcerer")){
            acrobatics.setVisibility(View.INVISIBLE);
            animalHandling.setVisibility(View.INVISIBLE);
            athletics.setVisibility(View.INVISIBLE);
            history.setVisibility(View.INVISIBLE);
            investigation.setVisibility(View.INVISIBLE);
            medicine.setVisibility(View.INVISIBLE);
            nature.setVisibility(View.INVISIBLE);
            perception.setVisibility(View.INVISIBLE);
            performance.setVisibility(View.INVISIBLE);
            sleightOfHand.setVisibility(View.INVISIBLE);
            stealth.setVisibility(View.INVISIBLE);
            survival.setVisibility(View.INVISIBLE);

            numSkills = numSkills +2;

        }else if (c.getCharacterClass().contains("Warlock")){
            acrobatics.setVisibility(View.INVISIBLE);
            animalHandling.setVisibility(View.INVISIBLE);
            athletics.setVisibility(View.INVISIBLE);
            insight.setVisibility(View.INVISIBLE);
            medicine.setVisibility(View.INVISIBLE);
            perception.setVisibility(View.INVISIBLE);
            performance.setVisibility(View.INVISIBLE);
            persuasion.setVisibility(View.INVISIBLE);
            sleightOfHand.setVisibility(View.INVISIBLE);
            stealth.setVisibility(View.INVISIBLE);
            survival.setVisibility(View.INVISIBLE);

            numSkills = numSkills +2;

        }else if (c.getCharacterClass().contains("Wizard")){
            acrobatics.setVisibility(View.INVISIBLE);
            animalHandling.setVisibility(View.INVISIBLE);
            athletics.setVisibility(View.INVISIBLE);
            deception.setVisibility(View.INVISIBLE);
            intimidation.setVisibility(View.INVISIBLE);
            nature.setVisibility(View.INVISIBLE);
            perception.setVisibility(View.INVISIBLE);
            performance.setVisibility(View.INVISIBLE);
            persuasion.setVisibility(View.INVISIBLE);
            sleightOfHand.setVisibility(View.INVISIBLE);
            stealth.setVisibility(View.INVISIBLE);
            survival.setVisibility(View.INVISIBLE);

            numSkills = numSkills +2;

        }






        selection.setText("Choose"+ numSkills +" From Below");




        buttonBack5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage5Listener.backFromStage5();
            }
        });
        buttonNext5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage5Listener.toStage6(c);
            }
        });


        return view;
    }


    ICreateCharacterStage5Listener CreateCharacterStage5Listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ICreateCharacterStage5Listener) {
            CreateCharacterStage5Listener = (ICreateCharacterStage5Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ICreateCharacterStage1Listener");
        }
    }

    public interface ICreateCharacterStage5Listener{
        void backFromStage5();
        void toStage6(Character c);
    }
}