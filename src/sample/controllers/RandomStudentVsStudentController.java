

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
import java.util.ArrayList;
import java.util.List;
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

    List<Student> listStudent= new ArrayList<>();
    Student studentQuestion;
    Student studentAnswer;


    @FXML
    void initialize() {
       listStudent.addAll(DataBaseHandler.getAllStudentsFromDB());
        backButton.setOnAction(event -> {
            for (Student student:
                 listStudent) {
                DataBaseHandler.setQuestionAndAnswerAndBalls(student);
            }
            backButton.getScene().getWindow().hide();
            try {
                main.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        startRandom.setOnAction(event -> {
            studentQuestion = listStudent.get((int) (Math.random() * listStudent.size()));
            studentAnswer = listStudent.get((int) (Math.random() * listStudent.size()));
            firstPair();
        });
        nextRandom.setOnAction(event -> {

            if (goodQuestionCheck.isSelected()) {
                studentQuestion.setQuestion("1");
                goodQuestionCheck.fire();
            }else studentQuestion.setQuestion("0");

            if (goodAnswerCheck.isSelected()) {
                studentAnswer.setAnswer("1");
                goodAnswerCheck.fire();
            }else studentAnswer.setAnswer("0");

            if (bonusBallCheckAnswer.isSelected()) {
                studentAnswer.setBonusBall("1");
                bonusBallCheckAnswer.fire();
            } studentAnswer.setBonusBall("0");


            for (Student student:
                 listStudent) {
                if(student.getId()==studentQuestion.getId()){
                    student=studentQuestion;
                }
                if(student.getId()==studentAnswer.getId()){
                    student=studentAnswer;
                }
            }

            nextPair();


        });


}

    private void nextPair() {
        if (studentAnswer.getQuestion().equals("x")) {
            studentQuestion = studentAnswer;
            studentAnswer = listStudent.get((int) (Math.random() * listStudent.size()));
            if (studentAnswer.getAnswer().equals("x"))
                studentNameAnswer.setText(studentAnswer.getLastname() + " " + studentAnswer.getName());
            else
                while (!studentAnswer.getAnswer().equals("x")) {
                    studentAnswer = listStudent.get((int) (Math.random() * listStudent.size()));
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
                studentQuestion = listStudent.get((int) (Math.random() * listStudent.size()));
        }
        if (studentAnswer.getAnswer().equals("x") && !studentAnswer.equals(studentQuestion)) {
            studentNameAnswer.setText(studentAnswer.getLastname() + " " + studentAnswer.getName());
        } else {
            while (!studentAnswer.getAnswer().equals("x"))
                studentAnswer = listStudent.get((int) (Math.random() * listStudent.size()));
        }
    }

}
