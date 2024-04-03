package com.example.actualfxproject;

import java.util.Random;

public class Room {
    private int locationX;
    private int locationY;
    private boolean isBlocked;
    private static NPCMonsters1 NPCMonsters;
    private int goldAmount;
    private int currentRow;
    private int currentColumn;

    public Room(int locationX, int locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.isBlocked = false; // Defaulting to not blocked
        this.NPCMonsters = null; // No monster by default
        this.goldAmount = 0; // No gold by default
        Random random = new Random();
        if (random.nextInt(2) == 1) {
            this.NPCMonsters = new NPCMonsters1();
        }
    }

    public static Room getRoom() {return null;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public static NPCMonsters1 getNpc() {
        return NPCMonsters;
    }

    public void setNpc(NPCMonsters1 NPCMonsters1) {
        this.NPCMonsters = NPCMonsters;
    }

    public int getGold() {
        return goldAmount;
    }

    public void setOccupant(NPCMonsters1 NPCMonsters) {
    }

    public boolean hasOccupant() {
        return false;
    }

    public Object getOccupant() {
        return null;
    }

    public int getcurrentRow() {
        return currentRow;
    }

    public void setcurrentRow(int row) {
        this.currentRow = currentRow;
    }

    public int getcurrentColumn() {
        return currentColumn;
    }

    public void setcurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }
}