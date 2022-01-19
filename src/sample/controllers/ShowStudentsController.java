package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import sample.Main;

public class ShowStudentsController {
    Main main = new Main();
    Stage stage = new Stage();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<?, ?> collumBonus;

    @FXML
    private TableColumn<?, ?> collumLastName;

    @FXML
    private TableColumn<?, ?> collumName;

    @FXML
    private TableColumn<?, ?> collumQuestion;

    @FXML
    private TableColumn<?, ?> collumTeam;

    @FXML
    private TableColumn<?, ?> collumAnswer;

    @FXML
    void initialize() {
        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            try {
                main.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

}
