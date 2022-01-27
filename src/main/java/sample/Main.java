package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        URL url = new File("/fxml/MainMenu.fxml").toURI().toURL();
//        Parent root = FXMLLoader.load(url);
//        Parent root = FXMLLoader.load(getClass().getResource("fxml/MainMenu.fxml"));
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("fxml/MainMenu.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MainMenu.fxml"));
        fxmlLoader.setClassLoader(getClass().getClassLoader());
//        fxmlLoader.setRoot(this);
//        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("RandomApl");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
