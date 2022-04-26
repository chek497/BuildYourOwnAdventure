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
import android.widget.Switch;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterCreationStage4Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationStage4Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private Character c;

    public CharacterCreationStage4Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment CharacterCreationStage4Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterCreationStage4Fragment newInstance(Character c) {
        CharacterCreationStage4Fragment fragment = new CharacterCreationStage4Fragment();
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
    Button buttonBack4;
    Button buttonNext4;

    Switch switchS;
    Switch switchD;
    Switch switchC;
    Switch switchI;
    Switch switchW;
    Switch switchCh;

    EditText PW;

    TextView speed;
    TextView HD;
    TextView CHP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_creation_stage4, container, false);

        buttonBack4 = view.findViewById(R.id.buttonBack4);
        buttonNext4 = view.findViewById(R.id.buttonNext4);

        switchS = view.findViewById(R.id.switchStrength);
        switchD = view.findViewById(R.id.switchDexterity);
        switchC = view.findViewById(R.id.switchConstitution);
        switchI = view.findViewById(R.id.switchIntelligence);
        switchW = view.findViewById(R.id.switchWisdom);
        switchCh = view.findViewById(R.id.switchCharisma);

        PW = view.findViewById(R.id.editTextNumberWisdom);

        speed = view.findViewById(R.id.textView38);
        HD = view.findViewById(R.id.textView40);
        CHP = view.findViewById(R.id.textView42);






        buttonBack4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage4Listener.backFromStage4();
            }
        });
        buttonNext4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage4Listener.toStage5(c);
            }
        });


        return view;
    }





    ICreateCharacterStage4Listener CreateCharacterStage4Listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ICreateCharacterStage4Listener) {
            CreateCharacterStage4Listener = (ICreateCharacterStage4Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ICreateCharacterStage1Listener");
        }
    }

    public interface ICreateCharacterStage4Listener{
        void backFromStage4();
        void toStage5(Character c);
    }
}