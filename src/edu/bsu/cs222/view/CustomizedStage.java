package edu.bsu.cs222.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomizedStage {

    private Stage secondaryStage;
    private int teamAmount;
    private int playerAmount;
    private Parent basicPlayer;

    public CustomizedStage(int teamAmount, int playerAmount) {
        this.teamAmount = teamAmount;
        this.playerAmount = playerAmount;
        setStage();
    }

    private void setStage() {
        secondaryStage = new Stage();
        secondaryStage.setTitle("Bowling Calculator");
        secondaryStage.setScene(new Scene(createUnclosableTabPane(), 300, 275));
    }

    private TabPane createUnclosableTabPane() {
        TabPane customizedPane = new TabPane();
        for (int i = 0; i < teamAmount; i++) {
            int teamNumber = i + 1;
            customizedPane.getTabs().add(createTeamTab("Team " + teamNumber));
        }
        customizedPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        return customizedPane;
    }

    private Tab createTeamTab(String name) {
        Accordion players = new Accordion();
        for (int i = 0; i < playerAmount; i++) {
            int playerNumber = i + 1;
            players.getPanes().add(createPlayerPane("../view/playerpane.fxml", "Player " + playerNumber));
        }
        return new Tab(name, players);
    }

    private TitledPane createPlayerPane(String path, String name) {
        readFXML(path);
        return new TitledPane(name, basicPlayer.lookup("GridPane"));
    }

    private void readFXML(String path) {
        try {
            basicPlayer = FXMLLoader.load(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getStage() {
        return secondaryStage;
    }

}
