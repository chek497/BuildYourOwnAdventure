package com.example.buildyourownadventure;

import android.media.Image;
import android.widget.ImageView;

import java.io.Serializable;

public class Character implements Serializable {


    int face;

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public Character(String race, String name, String characterClass, int face) {
        this.face = face;
        this.name = name;
        this.characterClass = characterClass;
        this.race = race;
    }

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
    Boolean AttributeStrength;
    Boolean AttributeDexterity;
    Boolean AttributeConstitution;
    Boolean AttributeIntelligence;
    Boolean AttributeWisdom;
    Boolean AttributeCharisma;

    Boolean AttributeAcrobatics;
    Boolean AttributeAnimalHandling;
    Boolean AttributeArcana;
    Boolean AttributeAthletics;
    Boolean AttributeDeception;
    Boolean AttributeHistory;
    Boolean AttributeInsight;
    Boolean AttributeIntimidation;
    Boolean AttributeInvestigation;
    Boolean AttributeMedicine;
    Boolean AttributeNature;
    Boolean AttributePerception;
    Boolean AttributePerformance;
    Boolean AttributePersuasion;
    Boolean AttributeReligion;
    Boolean AttributeSleightOfHand;
    Boolean AttributeStealth;
    Boolean AttributeSurvival;


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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String getPersonalityTraits() {
        return personalityTraits;
    }

    public void setPersonalityTraits(String personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public String getIdeals() {
        return ideals;
    }

    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }

    public String getBonds() {
        return bonds;
    }

    public void setBonds(String bonds) {
        this.bonds = bonds;
    }

    public String getFlaws() {
        return flaws;
    }

    public void setFlaws(String flaws) {
        this.flaws = flaws;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getTempHitPoints() {
        return tempHitPoints;
    }

    public void setTempHitPoints(int tempHitPoints) {
        this.tempHitPoints = tempHitPoints;
    }

    public int getBardicInspiration() {
        return bardicInspiration;
    }

    public void setBardicInspiration(int bardicInspiration) {
        this.bardicInspiration = bardicInspiration;
    }

    public int getOtherResource() {
        return otherResource;
    }

    public void setOtherResource(int otherResource) {
        this.otherResource = otherResource;
    }

    public int getCopper() {
        return copper;
    }

    public void setCopper(int copper) {
        this.copper = copper;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getElectrum() {
        return electrum;
    }

    public void setElectrum(int electrum) {
        this.electrum = electrum;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getPlatinum() {
        return platinum;
    }

    public void setPlatinum(int platinum) {
        this.platinum = platinum;
    }

    public Boolean getAttributeStrength() {
        return AttributeStrength;
    }

    public void setAttributeStrength(Boolean attributeStrength) {
        AttributeStrength = attributeStrength;
    }

    public String[][][] getToolProficiencies() {
        return toolProficiencies;
    }

    public void setToolProficiencies(String[][][] toolProficiencies) {
        this.toolProficiencies = toolProficiencies;
    }

    public Boolean getAttributeDexterity() {
        return AttributeDexterity;
    }

    public void setAttributeDexterity(Boolean attributeDexterity) {
        AttributeDexterity = attributeDexterity;
    }

    public Boolean getAttributeConstitution() {
        return AttributeConstitution;
    }

    public void setAttributeConstitution(Boolean attributeConstitution) {
        AttributeConstitution = attributeConstitution;
    }

    public Boolean getAttributeIntelligence() {
        return AttributeIntelligence;
    }

    public void setAttributeIntelligence(Boolean attributeIntelligence) {
        AttributeIntelligence = attributeIntelligence;
    }

    public Boolean getAttributeWisdom() {
        return AttributeWisdom;
    }

    public void setAttributeWisdom(Boolean attributeWisdom) {
        AttributeWisdom = attributeWisdom;
    }

    public Boolean getAttributeCharisma() {
        return AttributeCharisma;
    }

    public void setAttributeCharisma(Boolean attributeCharisma) {
        AttributeCharisma = attributeCharisma;
    }

    public Boolean getAttributeAcrobatics() {
        return AttributeAcrobatics;
    }

    public void setAttributeAcrobatics(Boolean attributeAcrobatics) {
        AttributeAcrobatics = attributeAcrobatics;
    }

    public Boolean getAttributeAnimalHandling() {
        return AttributeAnimalHandling;
    }

    public void setAttributeAnimalHandling(Boolean attributeAnimalHandling) {
        AttributeAnimalHandling = attributeAnimalHandling;
    }

    public Boolean getAttributeArcana() {
        return AttributeArcana;
    }

    public void setAttributeArcana(Boolean attributeArcana) {
        AttributeArcana = attributeArcana;
    }

    public Boolean getAttributeAthletics() {
        return AttributeAthletics;
    }

    public void setAttributeAthletics(Boolean attributeAthletics) {
        AttributeAthletics = attributeAthletics;
    }

    public Boolean getAttributeDeception() {
        return AttributeDeception;
    }

    public void setAttributeDeception(Boolean attributeDeception) {
        AttributeDeception = attributeDeception;
    }

    public Boolean getAttributeHistory() {
        return AttributeHistory;
    }

    public void setAttributeHistory(Boolean attributeHistory) {
        AttributeHistory = attributeHistory;
    }

    public Boolean getAttributeInsight() {
        return AttributeInsight;
    }

    public void setAttributeInsight(Boolean attributeInsight) {
        AttributeInsight = attributeInsight;
    }

    public Boolean getAttributeIntimidation() {
        return AttributeIntimidation;
    }

    public void setAttributeIntimidation(Boolean attributeIntimidation) {
        AttributeIntimidation = attributeIntimidation;
    }

    public Boolean getAttributeInvestigation() {
        return AttributeInvestigation;
    }

    public void setAttributeInvestigation(Boolean attributeInvestigation) {
        AttributeInvestigation = attributeInvestigation;
    }

    public Boolean getAttributeMedicine() {
        return AttributeMedicine;
    }

    public void setAttributeMedicine(Boolean attributeMedicine) {
        AttributeMedicine = attributeMedicine;
    }

    public Boolean getAttributeNature() {
        return AttributeNature;
    }

    public void setAttributeNature(Boolean attributeNature) {
        AttributeNature = attributeNature;
    }

    public Boolean getAttributePerception() {
        return AttributePerception;
    }

    public void setAttributePerception(Boolean attributePerception) {
        AttributePerception = attributePerception;
    }

    public Boolean getAttributePerformance() {
        return AttributePerformance;
    }

    public void setAttributePerformance(Boolean attributePerformance) {
        AttributePerformance = attributePerformance;
    }

    public Boolean getAttributePersuasion() {
        return AttributePersuasion;
    }

    public void setAttributePersuasion(Boolean attributePersuasion) {
        AttributePersuasion = attributePersuasion;
    }

    public Boolean getAttributeReligion() {
        return AttributeReligion;
    }

    public void setAttributeReligion(Boolean attributeReligion) {
        AttributeReligion = attributeReligion;
    }

    public Boolean getAttributeSleightOfHand() {
        return AttributeSleightOfHand;
    }

    public void setAttributeSleightOfHand(Boolean attributeSleightOfHand) {
        AttributeSleightOfHand = attributeSleightOfHand;
    }

    public Boolean getAttributeStealth() {
        return AttributeStealth;
    }

    public void setAttributeStealth(Boolean attributeStealth) {
        AttributeStealth = attributeStealth;
    }

    public Boolean getAttributeSurvival() {
        return AttributeSurvival;
    }

    public void setAttributeSurvival(Boolean attributeSurvival) {
        AttributeSurvival = attributeSurvival;
    }

    public int getFailures() {
        return failures;
    }

    public void setFailures(int failures) {
        this.failures = failures;
    }

    public int getSuccesses() {
        return successes;
    }

    public void setSuccesses(int successes) {
        this.successes = successes;
    }



    public Character(String name, String characterClass, String race) {
        this.name = name;
        this.characterClass = characterClass;
        this.race = race;
    }



    public Character() {

    }


}
