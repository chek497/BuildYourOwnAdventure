package com.example.buildyourownadventure;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterCreationStage6Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationStage6Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private Character c;

    public CharacterCreationStage6Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment CharacterCreationStage6Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterCreationStage6Fragment newInstance(Character c) {
        CharacterCreationStage6Fragment fragment = new CharacterCreationStage6Fragment();
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

    Button backButton;
    Button nextButton;
    Button standard;
    Button custom;

    TextView armorClass;
    TextView initiative;

    RequestQueue requestQueue;
    String url;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_character_creation_stage6, container, false);

        backButton = view.findViewById(R.id.buttonBack6);
        nextButton = view.findViewById(R.id.buttonNext6);
        standard = view.findViewById(R.id.buttonStandard);
        custom = view.findViewById(R.id.buttonCustom);

        armorClass = view.findViewById(R.id.textView46);
        initiative = view.findViewById(R.id.textView48);

        requestQueue = Volley.newRequestQueue(view.getContext());
        url = "https://www.dnd5eapi.co/api/backgrounds/acolyte";





        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage6Listener.backFromStage6();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage6Listener.toStage7(c);
            }
        });

        return view;
    }


    ICreateCharacterStage6Listener CreateCharacterStage6Listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ICreateCharacterStage6Listener) {
            CreateCharacterStage6Listener = (ICreateCharacterStage6Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ICreateCharacterStage1Listener");
        }
    }

    public interface ICreateCharacterStage6Listener{
        void backFromStage6();
        void toStage7(Character c);
    }
}