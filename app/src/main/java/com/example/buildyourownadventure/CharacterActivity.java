package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CharacterActivity extends AppCompatActivity implements CharacterFragment.ICreateCharacterListener, CharacterCreationStage1Fragment.ICreateCharacterStage1Listener, CharacterCreationStage2Fragment.ICreateCharacterStage2Listener,CharacterCreationStage3Fragment.ICreateCharacterStage3Listener,CharacterCreationStage4Fragment.ICreateCharacterStage4Listener, CharacterCreationStage5Fragment.ICreateCharacterStage5Listener{


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

    @Override
    public void backFromStage1() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toStage2() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage2Fragment.newInstance("",""), "fragment").addToBackStack(null).commit();

    }

    @Override
    public void backFromStage2() {
        getSupportFragmentManager().popBackStack();

    }

    @Override
    public void toStage3() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage3Fragment.newInstance("",""), "fragment").addToBackStack(null).commit();

    }

    @Override
    public void backFromStage3() {
        getSupportFragmentManager().popBackStack();

    }

    @Override
    public void toStage4() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage4Fragment.newInstance("",""), "fragment").addToBackStack(null).commit();

    }

    @Override
    public void backFromStage4() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toStage5() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage5Fragment.newInstance("",""), "fragment").addToBackStack(null).commit();

    }

    @Override
    public void backFromStage5() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toStage6() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage6Fragment.newInstance("",""), "fragment").addToBackStack(null).commit();

    }
}