package com.example.actualfxproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class AdventureGame extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AdventureGame.class.getResource("AdventureGameUi.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 735.0, 453.0);
        stage.setTitle("Adventure Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}