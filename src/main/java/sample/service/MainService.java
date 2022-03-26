package sample.service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.DataBase.DataBaseHandler;

import java.io.IOException;

public class MainService {
    Stage stage = new Stage();
    public void clickButton(Button addStudentButton, String s) {
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
    public void clear(Label successText){
        DataBaseHandler.clearMarks();
        successText.setText(" Marks successfully cleared!");
    }
}
