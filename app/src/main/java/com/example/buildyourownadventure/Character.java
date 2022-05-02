package com.example.buildyourownadventure;

import java.io.Serializable;

public class Character implements Serializable {



    String userId;

    String name;
    String characterClass;
    String background;

    String race;
    String subRace;

    String alignment;
    String hitDice;
    String[] skills;
    String[][][] toolProficiencies;
    String[][][] attacksSpells;
    String[][] typeProficiency;

    String[] equipment;
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
    int bardicInspiration;
    int otherResource;

    // ASM stands for ability score multiplier //
    int strength;
    int ASMStrength;

    int dexterity;
    int ASMDexterity;

    int constitution;
    int ASMConstitution;

    int intelligence;
    int ASMIntelligence;

    int wisdom;
    int ASMWisdom;

    int charisma;
    int ASMCharisma;


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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getSubRace() {
        return subRace;
    }

    public void setSubRace(String subRace) {
        this.subRace = subRace;
    }

    public String getHitDice() {
        return hitDice;
    }

    public void setHitDice(String hitDice) {
        this.hitDice = hitDice;
    }

    public int getPassiveWisdom() {
        return passiveWisdom;
    }

    public void setPassiveWisdom(int passiveWisdom) {
        this.passiveWisdom = passiveWisdom;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getASMStrength() {
        return ASMStrength;
    }

    public void setASMStrength(int ASMStrength) {
        this.ASMStrength = ASMStrength;
    }

    public int getASMDexterity() {
        return ASMDexterity;
    }

    public void setASMDexterity(int ASMDexterity) {
        this.ASMDexterity = ASMDexterity;
    }

    public int getASMConstitution() {
        return ASMConstitution;
    }

    public void setASMConstitution(int ASMConstitution) {
        this.ASMConstitution = ASMConstitution;
    }

    public int getASMIntelligence() {
        return ASMIntelligence;
    }

    public void setASMIntelligence(int ASMIntelligence) {
        this.ASMIntelligence = ASMIntelligence;
    }

    public int getASMWisdom() {
        return ASMWisdom;
    }

    public void setASMWisdom(int ASMWisdom) {
        this.ASMWisdom = ASMWisdom;
    }

    public int getASMCharisma() {
        return ASMCharisma;
    }

    public void setASMCharisma(int ASMCharisma) {
        this.ASMCharisma = ASMCharisma;
    }

    public Character(String name, String characterClass, String race) {
        this.name = name;
        this.characterClass = characterClass;
        this.race = race;
    }
    public Character() {

    }


}
