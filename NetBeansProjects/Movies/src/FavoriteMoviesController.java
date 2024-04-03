import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.*;
import java.util.ArrayList;

public class FavoriteMoviesController {

    @FXML
    private ListView<String> movieList;

    @FXML
    private TextField textField;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button saveButton;

    private ArrayList<String> listModel = new ArrayList<>();

    @FXML
    public void initialize() {
        movieList.getItems().addAll(listModel);

        addButton.setOnAction(e -> addMovie());
        removeButton.setOnAction(e -> removeMovie());
        loadButton.setOnAction(e -> loadMovies());
        saveButton.setOnAction(e -> saveMovies());
    }

    private void addMovie() {
        String movie = textField.getText().trim().toLowerCase();
        if (!movie.isEmpty()) {
            listModel.add(movie);
            movieList.getItems().add(movie);
            textField.clear();
        }
    }

    private void removeMovie() {
        int selectedIndex = movieList.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            listModel.remove(selectedIndex);
            movieList.getItems().remove(selectedIndex);
        } else {
            showAlert("Please select an item to delete!");
        }
    }

    private void loadMovies() {
        listModel.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("movies.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listModel.add(line);
            }
            movieList.getItems().setAll(listModel);
        } catch (IOException e) {
            showAlert("Error loading movies: " + e.getMessage());
        }
    }

    private void saveMovies() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("movies.txt"))) {
            for (String movie : listModel) {
                writer.println(movie);
            }
        } catch (IOException e) {
            showAlert("Error saving movies: " + e.getMessage());
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
