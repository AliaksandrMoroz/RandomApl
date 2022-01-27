package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {
    Stage stage = new Stage();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addStudentButton;

    @FXML
    private Button deleteStudentButton;

    @FXML
    private Button randomStudentVsStudentButton;

    @FXML
    private Button setStudentButton;

    @FXML
    private Button showStudentButton;

    @FXML
    void initialize() {

        clickButton(addStudentButton, "/fxml/AddStudentMenu.fxml");

        clickButton(deleteStudentButton, "/fxml/DeleteStudent.fxml");

        clickButton(setStudentButton, "/fxml/SetStudent.fxml");

        clickButton(showStudentButton, "/fxml/ShowStudents.fxml");

        clickButton(randomStudentVsStudentButton, "/fxml/RandomStudentVsStudent.fxml");


    }

    private void clickButton(Button addStudentButton, String s) {
        addStudentButton.setOnAction(event -> {
            addStudentButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(s));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.showAndWait();


        });
    }


}
