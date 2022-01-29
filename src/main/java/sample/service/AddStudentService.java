package sample.service;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.DataBase.DataBaseHandler;

public class AddStudentService {

    public void add(TextField enterNameLastnameField, Label errorText) {
        String[] addText = enterNameLastnameField.getText().trim().split("[^a-zA-Zа-яА-Я0-9_]+");
        if (!addText.equals("")) {
            DataBaseHandler.addStudentFromDB(addText[0], addText[1], addText[2]);
            errorText.setText(addText[0] + " " + addText[1] + " team № " + addText[2] + "successfully added!");
            enterNameLastnameField.setText("");
        } else {
            errorText.setText("Wrong data inserted!");
        }
    }
}

