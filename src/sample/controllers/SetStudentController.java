package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;

public class SetStudentController {
    Main main = new Main();
    Stage stage = new Stage();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addStudentButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField enterNameLastnameField;

    @FXML
    private TextField enterNameLastnameField1;

    @FXML
    private TextField enterNameLastnameField11;

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
