package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DataBase.DataBaseHandler;
import sample.Main;
import sample.service.SetStudentService;

import java.net.URL;
import java.util.ResourceBundle;

public class SetStudentController {
    Main main = new Main();
    Stage stage = new Stage();
    SetStudentService setStudentService = new SetStudentService();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button setStudentButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField enterNameLastnameField;

    @FXML
    private Label errorText;

    @FXML
    private TextField newStudentText;

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

        setStudentButton.setOnAction(event -> setStudentService.set(enterNameLastnameField,newStudentText,errorText)
        );
    }
}
