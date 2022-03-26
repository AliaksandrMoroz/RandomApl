package sample.service;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.DataBase.DataBaseHandler;

public class SetStudentService {
    public void set(TextField enterNameLastnameField, TextField newStudentText, Label errorText){
        String[] addText = enterNameLastnameField.getText().trim().split("[^a-zA-Zа-яА-Я0-9_]+");
        String[] newStudent = newStudentText.getText().trim().split("[^a-zA-Zа-яА-Я0-9_]+");
        if (!addText.equals("") && DataBaseHandler.getAllStudentsFromDB().stream()
                .anyMatch(student ->
                        (student.getName().equals(addText[1]) && student.getLastname().equals(addText[0])))) {
            DataBaseHandler.setStudentFromDB(addText[0], addText[1], newStudent[0], newStudent[1], newStudent[2]);
            errorText.setText(addText[0] + " " + addText[1] + " successfully changed!");
            enterNameLastnameField.setText("");
            newStudentText.setText("");
        } else {
            errorText.setText("Wrong data inserted!");
        }
    }
}
