package com.example.buildyourownadventure;

import java.io.Serializable;

public class Character implements Serializable {
    int delete;
    String name;
    String characterClass;
    String background;
    String race;
    String alignment;
    String[] savingThrows;
    String[] skills;
    String[][][] toolProficiencies;
    String[][][] attacksSpells;
    String[][] typeProficiency;
    String[][][] equipmentWeight;
    String personalityTraits;
    String ideals;
    String bonds;
    String flaws;
    String bio;

    int experiencePoints;
    int inspiration;
    int proficiencyBonus;
    int passiveWisdom;
    int armorClass;
    int initiative;
    int speed;
    int currentHitPoints;
    int tempHitPoints;
    int hitDice;
    int bardicInspiration;
    int otherResource;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;

    int failures;   /*Death*/
    int successes;  /*Saves*/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Character(String name, String characterClass, String race) {
        this.name = name;
        this.characterClass = characterClass;
        this.race = race;
    }
}
