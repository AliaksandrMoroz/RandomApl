package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.DataBase.DataBaseHandler;
import sample.Main;
import sample.entity.Student;
import sample.service.RandomStudentService;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class RandomStudentVsStudentController {
    Main main = new Main();
    Stage stage = new Stage();
    RandomStudentService randomStudentService = new RandomStudentService();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Label errorTEXT;

    @FXML
    private CheckBox bonusBallCheckAnswer;

    @FXML
    private CheckBox goodAnswerCheck;

    @FXML
    private CheckBox goodQuestionCheck;

    @FXML
    private Button nextRandom;

    @FXML
    private Button startRandom;

    @FXML
    private Label studentNameAnswer;

    @FXML
    private Label studentNameQuestion;


    @FXML
    void initialize() {

        backButton.setOnAction(event -> {
            for (Student student :
                    randomStudentService.getListStudent()) {
                DataBaseHandler.setQuestionAndAnswerAndBalls(student);
            }
            backButton.getScene().getWindow().hide();
            try {
                main.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        startRandom.setOnAction(event -> randomStudentService.firstPair(errorTEXT, studentNameQuestion, studentNameAnswer));

        nextRandom.setOnAction(event -> randomStudentService.nextRandom(
                goodQuestionCheck, goodAnswerCheck, bonusBallCheckAnswer, studentNameAnswer, studentNameQuestion,errorTEXT)
        );
    }


}
