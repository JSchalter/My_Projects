package com.example.badadventuregame;

import java.util.ArrayList;

public class   Map {
    ArrayList<Room> map;
    private int currentRow, currentColumn;

    public Map() {
        this.map = new ArrayList<>();
        currentRow = 0;
        currentColumn = 0;
        setMap();
    }

    public void setMap() {
        map.clear();
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                Room room = new Room(row, column);
                if (row == 1 && column == 2) {
                    room.setBlocked(true);
                } else if (row == 1 && column == 3) {
                    room.setBlocked(true);
                } else if (row == 1 && column == 4) {
                    room.setBlocked(true);
                } else if (row == 1 && column == 5) {
                    room.setBlocked(true);
                } else if (row == 1 && column == 6) {
                    room.setBlocked(true);
                } else if (row == 3 && column == 2) {
                    room.setBlocked(true);
                } else if (row == 3 && column == 3) {
                    room.setBlocked(true);
                } else if (row == 3 && column == 4) {
                    room.setBlocked(true);
                }
                map.add(room);

            }

        }

    }

    public String moveUp() {
        currentRow--;
        if ( currentRow < 0) {
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
        if ( currentRow >= 10) {
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
            if (room.getRow() == currentRow && room.getColumn() == currentColumn) {
                return room;
            }
        }
        return null;
    }
}
