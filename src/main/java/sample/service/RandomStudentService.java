package sample.service;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import sample.DataBase.DataBaseHandler;
import sample.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomStudentService {
    List<Student> listStudent = new ArrayList<>();
    List<Student> listStudentQuestion = new ArrayList<>();
    List<Student> listStudentAnswer = new ArrayList<>();

    public List<Student> getListStudent() {
        return listStudent;
    }

    Student studentQuestion;
    Student studentAnswer;

    public void firstPair(Label errorTEXT, Label studentNameQuestion, Label studentNameAnswer) {
        listStudent.addAll(DataBaseHandler.getAllStudentsFromDB());
        studentQuestion = listStudentQuestion.get((int) (Math.random() * listStudentQuestion.size()));
        studentAnswer = listStudentAnswer.get((int) (Math.random() * listStudentAnswer.size()));
        updateLists();
        if (listStudentAnswer.isEmpty() || listStudentQuestion.isEmpty()) {
            errorTEXT.setText("There is no more students left.");
        } else {
            studentNameQuestion.setText(studentQuestion.getLastname() + " " + studentQuestion.getName());
            studentAnswer = listStudentAnswer.stream()
                    .filter(a -> !a.equals(studentQuestion) && (a.getAnswer().equals("x")))
                    .collect(Collectors.toList())
                    .get((int) (Math.random() * listStudentAnswer.stream()
                            .filter(a -> !a.equals(studentQuestion) && (a.getAnswer().equals("x")))
                            .count()));
            if (studentAnswer.getQuestion().equals("x") && (!studentAnswer.getTeam().equals(studentQuestion.getTeam()))) {
                studentNameAnswer.setText(studentAnswer.getLastname() + " " + studentAnswer.getName());
            } else firstPair(errorTEXT,studentNameQuestion,studentNameAnswer);
        }
    }

    public void nextRandom(CheckBox goodQuestionCheck, CheckBox goodAnswerCheck, CheckBox bonusBallCheckAnswer,
                           Label studentNameAnswer, Label studentNameQuestion, Label errorTEXT) {
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

        for (Student student :
                listStudent) {
            if (student.getId() == studentAnswer.getId()) {
                student = studentAnswer;
            }
            if (student.getId() == studentQuestion.getId()) {
                student = studentQuestion;
            }
        }
        updateLists();
        nextPair(errorTEXT, studentNameAnswer);
        studentNameAnswer.setText(studentAnswer.getLastname() + " " + studentAnswer.getName());
        studentNameQuestion.setText(studentQuestion.getLastname() + " " + studentQuestion.getName());
    }

    public void nextPair(Label errorTEXT, Label studentNameAnswer) {
        updateLists();
        if (listStudentAnswer.isEmpty() || listStudentQuestion.isEmpty()) {
            errorTEXT.setText("There is no more students left.");
        } else {
            if (studentAnswer.getQuestion().equals("x")) {
                studentQuestion = studentAnswer;
                studentAnswer = listStudentAnswer.stream()
                        .filter(a -> !a.equals(studentQuestion) && (a.getAnswer().equals("x")))
                        .collect(Collectors.toList())
                        .get((int) (Math.random() * listStudentAnswer.stream()
                                .filter(a -> !a.equals(studentQuestion) && (a.getAnswer().equals("x")))

                                .count()));
                if (!studentAnswer.getTeam().equals(studentQuestion.getTeam())) {
                    studentNameAnswer.setText(studentAnswer.getLastname() + " " + studentAnswer.getName());
                } else nextPair(errorTEXT,studentNameAnswer);
            }
        }
    }

    private void updateLists() {
        listStudentQuestion = listStudent.stream().filter(a -> a.getQuestion().equals("x")).collect(Collectors.toList());
        listStudentAnswer = listStudent.stream().filter(a -> a.getAnswer().equals("x")).collect(Collectors.toList());
    }
}
