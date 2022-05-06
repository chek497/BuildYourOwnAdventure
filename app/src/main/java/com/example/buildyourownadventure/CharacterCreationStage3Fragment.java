package com.example.buildyourownadventure;

import static android.text.TextUtils.isEmpty;

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

import java.util.Random;

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

    Button buttonRoll;
    Button buttonRoll2;
    Button buttonRoll3;
    Button buttonRoll4;
    Button buttonRoll5;
    Button buttonRoll6;



    EditText strength1;
    EditText strength2;

    EditText Dexterity1;
    EditText Dexterity2;

    EditText Constitution1;
    EditText Constitution2;

    EditText Intelligence1;
    EditText Intelligence2;

    EditText Wisdom1;
    EditText Wisdom2;

    EditText Charisma1;
    EditText Charisma2;

    int diceTotal;

    int w;
    int x;
    int y;
    int z;



    public String findTotal(int one, int two, int three){
        String total = String.valueOf(one+two+three);
        return total;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_creation_stage3, container, false);

        buttonBack3 = view.findViewById(R.id.buttonBack3);
        buttonNext3 = view.findViewById(R.id.buttonNext3);

        buttonRoll = view.findViewById(R.id.buttonRoll);
        buttonRoll2 = view.findViewById(R.id.buttonRoll2);
        buttonRoll3 = view.findViewById(R.id.buttonRoll3);
        buttonRoll4 = view.findViewById(R.id.buttonRoll4);
        buttonRoll5 = view.findViewById(R.id.buttonRoll5);
        buttonRoll6 = view.findViewById(R.id.buttonRoll6);

        strength1 = view.findViewById(R.id.editTextNumberStrength1);
        strength2 = view.findViewById(R.id.editTextNumberStrength2);

        Dexterity1 = view.findViewById(R.id.editTextNumberDexterity1);
        Dexterity2 = view.findViewById(R.id.editTextNumberDexterity2);

        Constitution1 = view.findViewById(R.id.editTextNumberConstitution1);
        Constitution2 = view.findViewById(R.id.editTextNumberConstitution2);

        Intelligence1 = view.findViewById(R.id.editTextNumberIntelligence1);
        Intelligence2 = view.findViewById(R.id.editTextNumberIntelligence2);

        Wisdom1 = view.findViewById(R.id.editTextNumberWisdom1);
        Wisdom2 = view.findViewById(R.id.editTextNumberWisdom2);

        Charisma1 = view.findViewById(R.id.editTextNumberCharisma1);
        Charisma2 = view.findViewById(R.id.editTextNumberCharisma2);

        Random random = new Random();
        diceTotal = 0;




        buttonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                x = random.nextInt(6);
                y = random.nextInt(6);
                z = random.nextInt(6);

                strength1.setText(findTotal(x,y,z));
                strength2.setText(findTotal(x,y,z));

                c.setStrength(Integer.parseInt(strength2.getText().toString()));
                c.setASMStrength(Integer.parseInt(strength1.getText().toString()));

            }
        });

        buttonRoll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                x = random.nextInt(6);
                y = random.nextInt(6);
                z = random.nextInt(6);


                Dexterity1.setText(findTotal(x,y,z));
                Dexterity2.setText(findTotal(x,y,z));

                c.setDexterity(Integer.parseInt(Dexterity2.getText().toString()));
                c.setASMDexterity(Integer.parseInt(Dexterity1.getText().toString()));


            }
        });

        buttonRoll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                x = random.nextInt(6);
                y = random.nextInt(6);
                z = random.nextInt(6);

                //Need Constitution to determine Current health //
                Constitution1.setText(findTotal(x,y,z));
                Constitution2.setText(findTotal(x,y,z));

                c.setConstitution(Integer.parseInt(Constitution2.getText().toString()));
                c.setASMConstitution(Integer.parseInt(Constitution1.getText().toString())-10);


            }
        });

        buttonRoll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                x = random.nextInt(6);
                y = random.nextInt(6);
                z = random.nextInt(6);

                Intelligence1.setText(findTotal(x,y,z));
                Intelligence2.setText(findTotal(x,y,z));

                c.setIntelligence(Integer.parseInt(Intelligence2.getText().toString()));
                c.setASMIntelligence(Integer.parseInt(Intelligence1.getText().toString())-10);
            }
        });

        buttonRoll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                x = random.nextInt(6);
                y = random.nextInt(6);
                z = random.nextInt(6);

                Wisdom1.setText(findTotal(x,y,z));
                Wisdom2.setText(findTotal(x,y,z));

                c.setWisdom(Integer.parseInt(Wisdom2.getText().toString()));
                c.setASMWisdom(Integer.parseInt(Wisdom1.getText().toString())-10);
            }
        });

        buttonRoll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                x = random.nextInt(6);
                y = random.nextInt(6);
                z = random.nextInt(6);

                Charisma1.setText(findTotal(x,y,z));
                Charisma2.setText(findTotal(x,y,z));

                c.setCharisma(Integer.parseInt(Charisma2.getText().toString()));
                c.setASMCharisma(Integer.parseInt(Charisma1.getText().toString())-10);
            }
        });







        buttonBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage3Listener.backFromStage3();
            }
        });

        buttonNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                
                //TODO: add validation for the abiity scores, they can not be over 18. The highest number achievable when rolling four six sided dice and selecting the sum of the 3 highest values. //

                if(isEmpty( strength2.getText().toString())|| isEmpty(Dexterity2.getText().toString()) || isEmpty(Constitution2.getText().toString()) || isEmpty(Intelligence2.getText().toString()) || isEmpty(Wisdom2.getText().toString()) || isEmpty(Charisma2.getText().toString())){
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(view.getContext(), "All Characteristics must be filled", duration);
                    toast.show();
                }else {
                    c.setStrength(Integer.parseInt(strength2.getText().toString()));
                    c.setDexterity(Integer.parseInt(Dexterity2.getText().toString()));
                    c.setConstitution(Integer.parseInt(Constitution2.getText().toString()));
                    c.setIntelligence(Integer.parseInt(Intelligence2.getText().toString()));
                    c.setWisdom(Integer.parseInt(Wisdom2.getText().toString()));
                    c.setCharisma(Integer.parseInt(Charisma2.getText().toString()));

                    CreateCharacterStage3Listener.toStage4(c);
                }
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