package edu.bsu.cs222.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UserInterface extends Application {

    private Parent basicDisplay;

    @Override
    public void start(Stage primaryStage) {
        readFirstPane();
        primaryStage.setTitle("Welcome");
        primaryStage.setScene(new Scene(basicDisplay, 300, 275));
        primaryStage.show();
    }

    private void readFirstPane() {
        try {
            basicDisplay = FXMLLoader.load(getClass().getResource("../view/firstpane.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
