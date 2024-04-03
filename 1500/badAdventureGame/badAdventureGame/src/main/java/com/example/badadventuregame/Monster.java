package com.example.badadventuregame;

import java.util.Random;

public class Monster {
    private int hitPoints, strength, dexterity, intelligence;
    Random random = new Random();

    public Monster() {
        setHitPoints(rollDice());
        setStrength(rollDice() + rollDice());
        setDexterity(rollDice() + rollDice());
        setIntelligence(rollDice() + rollDice());
    }

    public int rollDice() {
        return random.nextInt(6) +1;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
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

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

}
