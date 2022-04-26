package com.example.buildyourownadventure;

import java.io.Serializable;

public class Character implements Serializable {




    String name;
    String characterClass;
    String background;
    String race;
    String alignment;
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



    int level;
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
    int copper;
    int silver;
    int electrum;
    int gold;
    int platinum;

    /*SavingThrows And Skills*/
    int AttributeStrength;
    int AttributeDexterity;
    int AttributeConstitution;
    int AttributeIntelligence;
    int AttributeWisdom;
    int AttributeCharisma;

    int AttributeAcrobatics;
    int AttributeAnimalHandling;
    int AttributeArcana;
    int AttributeAthletics;
    int AttributeDeception;
    int AttributeHistory;
    int AttributeInsight;
    int AttributeIntimidation;
    int AttributeInvestigation;
    int AttributeMedicine;
    int AttributeNature;
    int AttributePerception;
    int AttributePerformance;
    int AttributePersuasion;
    int AttributeReligion;
    int AttributeSleightOfHand;
    int AttributeStealth;
    int AttributeSurvival;


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

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getInspiration() {
        return inspiration;
    }

    public void setInspiration(int inspiration) {
        this.inspiration = inspiration;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public Character(String name, String characterClass, String race) {
        this.name = name;
        this.characterClass = characterClass;
        this.race = race;
    }
    public Character() {

    }


}
