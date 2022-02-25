package com.example.buildyourownadventure;

import java.io.Serializable;

public class Spell_S implements Serializable {
    String name;
    String description;

    public Spell_S(String name, String description) {
    this.name = name;
    this.description = description;
    }

    public Spell_S(){}

    @Override
    public String toString() {
        return name + " - " + description;
    }
}
