package com.example.actualfxproject;

import java.util.ArrayList;
import java.util.Random;

public class Map {
    ArrayList<Room> map;
    private int currentRow, currentColumn;
    private PlayerCharacter1 player; // Adding Player reference

    public Map() {
        this.map = new ArrayList<>();
        currentRow = 0;
        currentColumn = 0;
        setMap();
    }
    public void setMap() {
        map.clear();
        int totalRooms = 10 * 10;
        int roomsWithMonsters = totalRooms / 2; // At least one-third of rooms should have a Monster
        int roomsBlocked = totalRooms / 10; // At least one-third of rooms should be blocked

        ArrayList<Integer> monsterIndices = new ArrayList<>();
        ArrayList<Integer> blockedIndices = new ArrayList<>();

        Random random = new Random();
        while (monsterIndices.size() < roomsWithMonsters) {
            int randomIndex = random.nextInt(totalRooms);
            if (!monsterIndices.contains(randomIndex)) {
                monsterIndices.add(randomIndex);
            }
        }

        while (blockedIndices.size() < roomsBlocked) {
            int randomIndex = random.nextInt(totalRooms);
            if (!blockedIndices.contains(randomIndex)) {
                blockedIndices.add(randomIndex);
            }
        }

        for (int currentRow = 0; currentRow < 10; currentRow++) {
            for (int currentColumn = 0; currentColumn < 10; currentColumn++) {
                Room room = new Room(currentRow, currentColumn);

                int currentIndex = (currentRow * 10) + currentColumn;

                if (blockedIndices.contains(currentIndex)) {
                    room.setBlocked(true);
                }

                if (monsterIndices.contains(currentIndex)) {
                    room.setNpc(new NPCMonsters1());
                }

                map.add(room);
            }
        }
    }



    public String moveUp() {
        currentRow--;
        if (currentRow < 0) {
            currentRow = 0;
            return "Cannot move further up!";
        } else if (getRoom().isBlocked()) {
            currentRow++;
            return "This room is blocked! Pick another direction.";
        } else {

            return "Player moved up one room!";
        }
    }

    public String moveDown() {
        currentRow++;
        if (currentRow >= 10) {
            currentRow = 9;
            return "Cannot move further down!";

        } else if (getRoom().isBlocked()) {
            currentRow--;
            return "This room is blocked! Pick another direction.";
        } else {

            return "Player moved down one room!";
        }

    }

    public String moveLeft() {
        currentColumn--;
        if (currentColumn < 0) {
            currentColumn = 0;
            return "Cannot move further left!";
        } else if (getRoom().isBlocked()) {
            currentColumn++;
            return "This room is blocked! Pick another direction.";
        } else {

            return "Player moved left one room!";
        }

    }

    public String moveRight() {
        currentColumn++;
        if (currentColumn >= 10) {
            currentColumn = 9;
            return "Cannot move further right!";
        } else if (getRoom().isBlocked()) {
            currentColumn--;
            return "This room is blocked! Pick another direction.";
        } else {
            return "Player moved right one room!";
        }

    }

    public String displayMap() {
        String printInfo = "";
        int index = 0;
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                if (row == currentRow && column == currentColumn) {
                    printInfo += "|@";
                } else if (map.get(index).isBlocked()) {
                    printInfo += "| X ";
                } else {
                    printInfo += "|    ";
                }
                index++;
            }
            printInfo += "|\n";
        }

        return printInfo;
    }

    public Room getRoom() {
        for (Room room : map) {
            if (room.getcurrentRow() == currentRow && room.getcurrentColumn() == currentColumn) {
                return room;
            }
        }
        return null;
    }
    public PlayerCharacter1 getPlayer() {
        return player;
    }

    public void setPlayerCharacter1(PlayerCharacter1 player) {
        this.player = player;
    }
}