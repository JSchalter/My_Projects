package com.example.badadventuregame;

import java.util.Random;

public class Player {
    private int hitPoints, strength, dexterity, intelligence, totalGold;
    Random random = new Random();

    public Player() {
        setHitPoints(20);
        setStrength(rollDice() + rollDice() + rollDice());
        setDexterity(rollDice() + rollDice() + rollDice());
        setIntelligence(rollDice() + rollDice() + rollDice());
        setTotalGold(0);
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

    public int getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(int totalGold) {
        this.totalGold += totalGold;
    }
}
