

package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.DataBase.DataBaseHandler;
import sample.Main;
import sample.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class RandomStudentVsStudentController {
    Main main = new Main();
    Stage stage = new Stage();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

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
    Student studentQuestion;
    Student studentAnswer;


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
        startRandom.setOnAction(event -> {
            studentQuestion = DataBaseHandler.getAllStudentsFromDB().get((int) (Math.random() * DataBaseHandler.getAllStudentsFromDB().size()));
            studentAnswer = DataBaseHandler.getAllStudentsFromDB().get((int) (Math.random() * DataBaseHandler.getAllStudentsFromDB().size()));
            firstPair();
        });
        nextRandom.setOnAction(event -> {
            String checkGoodQuestion;
            String checkGoodAnswer;
            String checkBonusBallAnswer;

            if (goodQuestionCheck.isSelected()) {
                checkGoodQuestion = "1";
                goodQuestionCheck.fire();
            } else
                checkGoodQuestion = "0";

            if (goodAnswerCheck.isSelected()) {
                checkGoodAnswer = "1";
                goodAnswerCheck.fire();
            } else
                checkGoodAnswer = "0";

            if (bonusBallCheckAnswer.isSelected()) {
                checkBonusBallAnswer = "1";
                bonusBallCheckAnswer.fire();
            } else
                checkBonusBallAnswer = "0";


            DataBaseHandler.setQuestionAndAnswerAndBalls(checkGoodQuestion, studentQuestion.getAnswer(), studentQuestion.getBonusBall(), studentQuestion.getId());
            DataBaseHandler.setQuestionAndAnswerAndBalls(studentAnswer.getQuestion(), checkGoodAnswer, checkBonusBallAnswer, studentAnswer.getId());

            nextPair();


        });


}

    private void nextPair() {
        if (studentAnswer.getQuestion().equals("x")) {
            studentQuestion = studentAnswer;
            studentAnswer = DataBaseHandler.getAllStudentsFromDB().get((int) (Math.random() * DataBaseHandler.getAllStudentsFromDB().size()));
            if (studentAnswer.getAnswer().equals("x"))
                studentNameAnswer.setText(studentAnswer.getLastname() + " " + studentAnswer.getName());
            else
                while (!studentAnswer.getAnswer().equals("x")) {
                    studentAnswer = DataBaseHandler.getAllStudentsFromDB().get((int) (Math.random() * DataBaseHandler.getAllStudentsFromDB().size()));
                }
            studentNameAnswer.setText(studentAnswer.getLastname() + " " + studentAnswer.getName());

        }else firstPair();
        studentNameQuestion.setText(studentQuestion.getLastname() + " " + studentQuestion.getName());
    }


    private void firstPair() {
        if (studentQuestion.getQuestion().equals("x") && !studentQuestion.equals(studentAnswer)) {
            studentNameQuestion.setText(studentQuestion.getLastname() + " " + studentQuestion.getName());
        } else {
            while (!studentQuestion.getQuestion().equals("x"))
                studentQuestion = DataBaseHandler.getAllStudentsFromDB().get((int) (Math.random() * DataBaseHandler.getAllStudentsFromDB().size()));
        }
        if (studentAnswer.getAnswer().equals("x") && !studentAnswer.equals(studentQuestion)) {
            studentNameAnswer.setText(studentAnswer.getLastname() + " " + studentAnswer.getName());
        } else {
            while (!studentAnswer.getAnswer().equals("x"))
                studentAnswer = DataBaseHandler.getAllStudentsFromDB().get((int) (Math.random() * DataBaseHandler.getAllStudentsFromDB().size()));
        }
    }

}
