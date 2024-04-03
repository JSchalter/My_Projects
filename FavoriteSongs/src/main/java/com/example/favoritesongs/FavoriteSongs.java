package com.example.favoritesongs;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.PrintWriter;

import java.util.Scanner;

import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.collections.ObservableList;

import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.Scene;

import javafx.scene.control.Alert;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.ListView;

import javafx.scene.control.SelectionMode;

import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.HBox;

import javafx.stage.Stage;

public class FavoriteSongs extends Application {

//declaring important UI components

    TextField input;
    TextField input1;
    TextField input2;
    TextField input3;
    TextField input4;
    TextField input5;


    ListView<String> listView;


    Button addBtn, removeBtn, loadBtn, saveBtn;

//file n

    String fileName = "songs.txt";

    @Override

    public void start(Stage primaryStage) {

//creating a border pane, adjusting padding

        BorderPane root = new BorderPane();

        root.setPadding(new Insets(15));

//label and text field for input

        Label label = new Label("Enter the date: ");
        input = new TextField();
        Label label2 = new Label("Enter the tutor name: ");
        input1 = new TextField();
        Label label3 = new Label("Enter the student name and student ID: ");
        input2 = new TextField();
        Label label4 = new Label("Enter the course name: ");
        input3 = new TextField();
        Label label5= new Label("Enter the time frame: ");
        input4 = new TextField();
        Label label6 = new Label("Did the student show up: ");
        input5 = new TextField();


//adding both to an HBox

        HBox box1 = new HBox(label, input, label2, input1, label3, input2, label4, input3, label5, input4, label6, input5);

        box1.setSpacing(10);

        box1.setPadding(new Insets(5));

//initializing list view, enabling multi select

        listView = new ListView<String>();

        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

//initializing buttons

        addBtn = new Button("Add");

        removeBtn = new Button("Remove");

        loadBtn = new Button("Load");

        saveBtn = new Button("Save");

//adding event listeners

        addBtn.setOnAction(e -> {

//fetching name, converting to lower case, removing trailing/leading white space

//and adding to listView

            String name = input.getText().toLowerCase().trim();

            listView.getItems().add(name);

            input.setText(""); //clearing input field

            String name1 = input1.getText().toLowerCase().trim();

            listView.getItems().add(name1);

            input1.setText(""); //clearing input field

            String name2 = input2.getText().toLowerCase().trim();

            listView.getItems().add(name2);

            input2.setText(""); //clearing input field

            String name3 = input3.getText().toLowerCase().trim();

            listView.getItems().add(name3);

            input3.setText(""); //clearing input field

            String name4 = input4.getText().toLowerCase().trim();

            listView.getItems().add(name4);

            input4.setText(""); //clearing input field

            String name5 = input5.getText().toLowerCase().trim();

            listView.getItems().add(name5);

            input5.setText(""); //clearing input field

        });

//also adding the same listener to input text field, so that user can simply press enter key

//after typing name, to add it. remove if not needed

        input.setOnAction(addBtn.getOnAction());
        input1.setOnAction(addBtn.getOnAction());
        input2.setOnAction(addBtn.getOnAction());
        removeBtn.setOnAction(e -> {

//getting list of selected items

            ObservableList<String> items = listView.getSelectionModel().getSelectedItems();

            if (items.isEmpty()) {

//nothing is selected, displaying an error message

                displayMessage("Please select an item to delete!");

            } else {

//removing all selected items from listView. note: if there are duplicate items in listView,

//selecting and removing one item will remove all the occurrences of that item

                listView.getItems().removeAll(items);

            }

        });

        saveBtn.setOnAction(e -> {

            try {

//opening file in write mode

                PrintWriter writer = new PrintWriter(new File(fileName));

//writing all songs to file

                for (String name : listView.getItems()) {

                    writer.println(name);

                }
                for (String name1 : listView.getItems()) {

                    writer.println(name1);

                }
                for (String name2 : listView.getItems()) {

                    writer.println(name2);

                }
                for (String name3 : listView.getItems()) {

                    writer.println(name3);

                }
                for (String name4 : listView.getItems()) {

                    writer.println(name4);

                }
                for (String name5 : listView.getItems()) {

                    writer.println(name5);

                }
                for (String name6 : listView.getItems()) {

                    writer.println(name6);

                }

//closing, saving changes

                writer.close();

//letting the user know the status

                displayMessage("saved to " + fileName);

            } catch (FileNotFoundException ex) {

                displayMessage("Error occurred while opening " + fileName + " file");

            }

        });

        loadBtn.setOnAction(e -> {

            try {

//clearing current contents

                listView.getItems().clear();

//opening file,

                Scanner sc = new Scanner(new File(fileName));

//looping and adding each item on the file to listView

                while (sc.hasNext()) {

                    listView.getItems().add(sc.nextLine().trim());

                }

                sc.close();

            } catch (FileNotFoundException ex) {

                displayMessage("Error occurred while opening " + fileName + " file");

            }

        });

//adding buttons to an HBox

        HBox btns = new HBox(addBtn, removeBtn, loadBtn, saveBtn);

        btns.setAlignment(Pos.CENTER);

        btns.setSpacing(10);

        btns.setPadding(new Insets(5));

//ading everything to border pane

        root.setTop(box1);

        root.setBottom(btns);

        root.setCenter(listView);

//setting up and displaying a scene

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Tutor Session Record Academic Support Center Orchard Ridge Campus");

        primaryStage.show();

    }

//helper method to display a pop up message to the user.

    private void displayMessage(String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);

        alert.setHeaderText("");

        alert.showAndWait();

    }

    public static void main(String[] args) {

        launch(args);

    }

}

/*OUTPUT*/