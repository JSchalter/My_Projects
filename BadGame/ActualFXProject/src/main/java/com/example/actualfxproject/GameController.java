package com.example.actualfxproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Random;

public class GameController {
    PlayerCharacter1 player;
    Map map;
    Random random = new Random();

    @FXML
    private Button start;

    @FXML
    private Label gamemap;

    @FXML
    private Button down;

    @FXML
    private Label dx;

    @FXML
    private Button fight;

    @FXML
    private Label gameStatus;

    @FXML
    private Label hp;

    @FXML
    private Label it;

    @FXML
    private Button left;

    @FXML
    private Button right;

    @FXML
    private Button run;

    @FXML
    private Button search;

    @FXML
    private Button sleep;

    @FXML
    private Label st;

    @FXML
    private Label tg;

    @FXML
    private Button up;

    @FXML
    void southButtonClicked(ActionEvent event) {
        String status = map.moveDown();
        gameStatus.setText(status);
        gamemap.setText("");
        gamemap.setText(map.displayMap());
    }

    @FXML
    void fightButtonClicked(ActionEvent event) {
        Room room = map.getRoom();
        if (room.getNpc() != null) {
            if (onRoll(20) >= room.getNpc().getDexterity()) {
                room.getNpc().setHitPoints(room.getNpc().getHitPoints() - (player.getStrength() / 3));
                gameStatus.setText("You hit the monster! ");
            } else {
                gameStatus.setText(" you didn't hit the monster!");
            }
            if (room.getNpc().getHitPoints() > 0) {
                player.setHitPoints(player.getHitPoints() - (room.getNpc().getStrength() / 1));
                gameStatus.setText("The monster hit you! ");
            } else {
                gameStatus.setText(" The monster didn't hit you!");
            }
        } else {
            gameStatus.setText("There is no monster in the room!");
        }
        playerInfo();
    }

    @FXML
    void westButtonClicked(ActionEvent event) {
        String status = map.moveLeft();
        gameStatus.setText(status);
        // gamemap.setText("");
        gamemap.setText(map.displayMap());
    }

    @FXML
    void eastButtonClicked(ActionEvent event) {
        String status = map.moveRight();
        gameStatus.setText(status);
        //gamemap.setText("");
        gamemap.setText(map.displayMap());
    }

    @FXML
    void runButtonClicked(ActionEvent event) {
        Room room = map.getRoom();
        if (room.getNpc() != null) {
            if (onRoll(20) < room.getNpc().getIntelligence()) {
                gameStatus.setText("The monster saw you! ");
                fightButtonClicked(event);
            } else {
                gameStatus.setText("The monster didn't see you!");
            }
        } else {
            gameStatus.setText("There is no monster in the room!");
        }
        playerInfo();
    }

    @FXML
    void searchButtonClicked(ActionEvent event) {
        Room room = map.getRoom();
        if (onRoll(20) < player.getIntelligence()) {
            player.setGold(room.getGold());
            gameStatus.setText("you found " + room.getGold() + " gold!");
        } else {
            gameStatus.setText(" you didn't find anything!");
        }
        playerInfo();
    }

    @FXML
    void sleepButtonClicked(ActionEvent event) {
        player.setHitPoints(20);
        Room room = map.getRoom();
        if (room.getNpc() != null) {
            if (onRoll(6) == 3) {
                gameStatus.setText("The monster saw you! ");
                fightButtonClicked(event);
            } else {
                gameStatus.setText("The monster didn't see you!");
            }
        } else {
            gameStatus.setText("There is no monster in the room!");
        }
        playerInfo();
    }

    @FXML
    void onStart(ActionEvent event) {
        player = new PlayerCharacter1();
        map = new Map();
        fight.setDisable(false);
        search.setDisable(false);
        run.setDisable(false);
        sleep.setDisable(false);
        up.setDisable(false);
        down.setDisable(false);
        left.setDisable(false);
        right.setDisable(false);
        start.setDisable(true);
        playerInfo();
        gamemap.setText(map.displayMap());
    }

    @FXML
    void northButtonClicked(ActionEvent event) {
        String status = map.moveUp();
        gameStatus.setText(status);
        gamemap.setText("");
        gamemap.setText(map.displayMap());

    }

    void playerInfo() {
        hp.setText(player.getHitPoints() + "");
        dx.setText(player.getDexterity() + "");
        it.setText(player.getIntelligence() + "");
        st.setText(player.getStrength() + "");
        tg.setText(player.getGoldAmount() + "");
        if (player.getHitPoints() <= 0) {
            gameStatus.setText("Game Over!");
            fight.setDisable(true);
            search.setDisable(true);
            run.setDisable(true);
            sleep.setDisable(true);
            up.setDisable(true);
            down.setDisable(true);
            left.setDisable(true);
            right.setDisable(true);
            start.setDisable(false);
        }
    }

    int onRoll(int numSide) {
        return random.nextInt(numSide) + 1;
    }
}
