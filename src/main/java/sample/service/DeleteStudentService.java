package sample.service;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.DataBase.DataBaseHandler;

public class DeleteStudentService {
    public void deleteStudent(TextField enterNameLastnameField, Label errorText){
        String[] addText = enterNameLastnameField.getText().trim().split("[^a-zA-Zа-яА-Я0-9_]+");
        if (!addText.equals("") && DataBaseHandler.getAllStudentsFromDB().stream()
                .anyMatch(student ->
                        (student.getName().equals(addText[1]) && student.getLastname().equals(addText[0])))) {
            DataBaseHandler.deleteStudentFromDB(addText[0], addText[1]);
            errorText.setText(addText[0] + " " + addText[1] + " successfully deleted!");
            enterNameLastnameField.setText("");
        } else
            errorText.setText("Wrong data inserted!");
    };
    }

