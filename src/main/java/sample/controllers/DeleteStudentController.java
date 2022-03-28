package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DataBase.DataBaseHandler;
import sample.Main;
import sample.service.DeleteStudentService;

public class DeleteStudentController {
    Main main = new Main();
    Stage stage = new Stage();
    DeleteStudentService deleteStudentService = new DeleteStudentService();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteStudentButton;

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
        deleteStudentButton.setOnAction(event ->
                deleteStudentService.deleteStudent(enterNameLastnameField, errorText));

    }
}
