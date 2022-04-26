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
    public void toStage2(Character c) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage2Fragment.newInstance(c), "fragment").addToBackStack(null).commit();

    }

    @Override
    public void backFromStage2() {
        getSupportFragmentManager().popBackStack();

    }

    @Override
    public void toStage3(Character c) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage3Fragment.newInstance(c), "fragment").addToBackStack(null).commit();

    }

    @Override
    public void backFromStage3() {
        getSupportFragmentManager().popBackStack();

    }

    @Override
    public void toStage4(Character c) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage4Fragment.newInstance(c), "fragment").addToBackStack(null).commit();

    }

    @Override
    public void backFromStage4() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toStage5(Character c) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage5Fragment.newInstance(c), "fragment").addToBackStack(null).commit();

    }

    @Override
    public void backFromStage5() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toStage6(Character c) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage6Fragment.newInstance(c), "fragment").addToBackStack(null).commit();

    }

    @Override
    public void backFromStage6() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toStage7(Character c) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage7Fragment.newInstance(c), "fragment").addToBackStack(null).commit();
    }

    @Override
    public void backFromStage7() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toStage8(Character c) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage8Fragment.newInstance(c), "fragment").addToBackStack(null).commit();
    }

    @Override
    public void backFromStage8() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toStage9(Character c) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage9Fragment.newInstance(c), "fragment").addToBackStack(null).commit();
    }

    @Override
    public void backFromStage9() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toStage10(Character c) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, CharacterCreationStage10Fragment.newInstance(c), "fragment").addToBackStack(null).commit();
    }

    @Override
    public void backFromStage10() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void createCharacter(Character c) {

    }
}