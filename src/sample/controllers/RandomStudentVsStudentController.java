

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
import java.util.Iterator;
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

    List<Student> listStudent = new ArrayList<>();
    List<Student> listStudentQuestion = new ArrayList<>();
    List<Student> listStudentAnswer = new ArrayList<>();
    Student studentQuestion;
    Student studentAnswer;


    @FXML
    void initialize() {
        listStudent.addAll(DataBaseHandler.getAllStudentsFromDB());
        for (Student student :
                listStudent) {
            if (student.getAnswer().equals("x")) {
                listStudentAnswer.add(student);
            }
            if (student.getQuestion().equals("x")) {
                listStudentQuestion.add(student);
            }
        }
        backButton.setOnAction(event -> {
            for (Student student :
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
            studentQuestion = listStudentQuestion.get((int) (Math.random() * listStudentQuestion.size()));
            studentAnswer = listStudentAnswer.get((int) (Math.random() * listStudentAnswer.size()));
            firstPair();
        });
        nextRandom.setOnAction(event -> {

            if (goodQuestionCheck.isSelected()) {
                studentQuestion.setQuestion("1");
                goodQuestionCheck.fire();
            } else studentQuestion.setQuestion("0");

            if (goodAnswerCheck.isSelected()) {
                studentAnswer.setAnswer("1");
                goodAnswerCheck.fire();
            } else studentAnswer.setAnswer("0");

            if (bonusBallCheckAnswer.isSelected()) {
                studentAnswer.setBonusBall("1");
                bonusBallCheckAnswer.fire();
            }
            studentAnswer.setBonusBall("0");

            for (int i = 0; i < listStudentQuestion.size(); i++) {
                if (!listStudentQuestion.get(i).getQuestion().equals("x")) {
                    listStudentQuestion.remove(i);
                    i--;
                }
            }
            for (int i = 0; i < listStudentAnswer.size(); i++) {
                if (!listStudentAnswer.get(i).getAnswer().equals("x")) {
                    listStudentAnswer.remove(i);
                    i--;
                }

            }


            for (Student student :
                    listStudent) {
                if (student.getId() == studentQuestion.getId()) {
                    student = studentQuestion;
                }
                if (student.getId() == studentAnswer.getId()) {
                    student = studentAnswer;
                }
            }

            nextPair();
            studentNameAnswer.setText(studentAnswer.getLastname() + " " + studentAnswer.getName());
            studentNameQuestion.setText(studentQuestion.getLastname() + " " + studentQuestion.getName());

        });


    }

    private void nextPair() {
        if (studentAnswer.getQuestion().equals("x")) {
            studentQuestion = studentAnswer;
            studentAnswer = listStudentAnswer.get((int) (Math.random() * listStudentAnswer.size()));
            if (studentAnswer.getAnswer().equals("x"))
                studentNameAnswer.setText(studentAnswer.getLastname() + " " + studentAnswer.getName());
            else {
                for (Student student :
                        listStudentAnswer) {
                    if (student.getAnswer().equals("x")&&!(student.getId() ==studentQuestion.getId())) {
                        studentAnswer = student;
                    }
                }
            }
            studentNameAnswer.setText(studentAnswer.getLastname() + " " + studentAnswer.getName());

        } else firstPair();
        studentNameQuestion.setText(studentQuestion.getLastname() + " " + studentQuestion.getName());
    }


    private void firstPair() {
        if (studentQuestion.getQuestion().equals("x") && !studentQuestion.equals(studentAnswer)) {
            studentNameQuestion.setText(studentQuestion.getLastname() + " " + studentQuestion.getName());
        } else {
            for (Student student :
                    listStudentQuestion) {
                if (student.getQuestion().equals("x")&&!(student.getId() ==studentAnswer.getId())) {
                    studentQuestion = student;
                }
            }
        }
        if (studentAnswer.getAnswer().equals("x") && !studentAnswer.equals(studentQuestion)) {
            studentNameAnswer.setText(studentAnswer.getLastname() + " " + studentAnswer.getName());
        } else {
            for (Student student :
                    listStudentAnswer) {
                if (student.getAnswer().equals("x")&& !(student.getId() ==studentQuestion.getId())) {
                    studentAnswer = student;
                }
            }
        }

    }
}
