package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader ( getClass().getResource( "calculator.fxml" ));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root, 500, 325));
            primaryStage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
