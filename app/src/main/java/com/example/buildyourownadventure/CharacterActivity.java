package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CharacterActivity extends AppCompatActivity implements CharacterFragment.ICreateCharacterListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character2);




        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView2, CharacterFragment.newInstance("",""), "fragment").commit();
    }



    @Override
    public void newCharacter() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage1Fragment.newInstance("",""), "fragment").addToBackStack(null).commit();
    }
}