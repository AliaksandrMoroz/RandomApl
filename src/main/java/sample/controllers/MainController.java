package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.DataBase.DataBaseHandler;
import sample.service.MainService;

public class MainController {
    MainService mainService;

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
    private Button clearMarksButton;

    @FXML
    private Label successText;

    @FXML
    void initialize() {
        mainService.clickButton(addStudentButton, "/fxml/AddStudentMenu.fxml");

        mainService.clickButton(deleteStudentButton, "/fxml/DeleteStudent.fxml");

        mainService.clickButton(setStudentButton, "/fxml/SetStudent.fxml");

        mainService.clickButton(showStudentButton, "/fxml/ShowStudents.fxml");

        mainService.clickButton(randomStudentVsStudentButton, "/fxml/RandomStudentVsStudent.fxml");

        clearMarksButton.setOnAction((event) -> mainService.clear(successText));
    }


}
