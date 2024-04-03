package com.example.badadventuregame;

import java.util.Random;

public class Room {
    private int row, column, gold;
    private boolean isBlocked;
    private Monster npc;
    Random random = new Random();

    public Room(int row, int column) {
        this.row = row;
        this.column = column;
        this.isBlocked = false;
        this.gold = rollDice();
        if (random.nextInt(2) == 1)
            this.npc = new Monster();
        else
            this.npc = null;

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public Monster getNpc() {
        return npc;
    }

    public void setNpc(Monster npc) {
        this.npc = npc;
    }

    public int rollDice() {
        return random.nextInt(15);
    }
}
