package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DataBase.DataBaseHandler;
import sample.Main;
import sample.service.AddStudentService;

import java.net.URL;
import java.util.ResourceBundle;

public class AddStudentController {
    Main main = new Main();
    Stage stage = new Stage();
    AddStudentService addStudentService= new AddStudentService();

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
    private Label errorText;

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
        addStudentButton.setOnAction(event -> addStudentService.add(enterNameLastnameField, errorText));

    }
}
