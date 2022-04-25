package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class CharacterActivity extends AppCompatActivity implements CharacterFragment.ICreateCharacterListener, CharacterCreationStage1Fragment.ICreateCharacterStage1Listener, CharacterCreationStage2Fragment.ICreateCharacterStage2Listener,CharacterCreationStage3Fragment.ICreateCharacterStage3Listener,CharacterCreationStage4Fragment.ICreateCharacterStage4Listener, CharacterCreationStage5Fragment.ICreateCharacterStage5Listener, CharacterCreationStage6Fragment.ICreateCharacterStage6Listener, CharacterCreationStage7Fragment.ICreateCharacterStage7Listener, CharacterCreationStage8Fragment.ICreateCharacterStage8Listener, CharacterCreationStage9Fragment.ICreateCharacterStage9Listener, CharacterCreationStage10Fragment.ICreateCharacterStage10Listener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character2);




        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView2, CharacterFragment.newInstance("",""), "fragment").addToBackStack(null).commit();
    }



    @Override
    public void newCharacter() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage1Fragment.newInstance("",""), "fragment").addToBackStack(null).commit();
    }

    @Override
    public void backToCharacterActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void backFromStage1() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toStage2(String s, String p, String o, String n, int g) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage2Fragment.newInstance(s,p, o, n, g), "fragment").addToBackStack(null).commit();

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

    @Override
    public void backFromStage6() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toStage7() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage7Fragment.newInstance("",""), "fragment").addToBackStack(null).commit();
    }

    @Override
    public void backFromStage7() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toStage8() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage8Fragment.newInstance("",""), "fragment").addToBackStack(null).commit();
    }

    @Override
    public void backFromStage8() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toStage9() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage9Fragment.newInstance("",""), "fragment").addToBackStack(null).commit();
    }

    @Override
    public void backFromStage9() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toStage10() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage10Fragment.newInstance("",""), "fragment").addToBackStack(null).commit();
    }

    @Override
    public void backFromStage10() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void createCharacter() {

    }
}