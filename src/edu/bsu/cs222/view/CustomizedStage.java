package edu.bsu.cs222.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class CustomizedStage {
    private Stage secondaryStage;
    private int teamAmount;
    private int playerAmount;
    private Parent basicPlayer;

    public CustomizedStage(int teamAmountInput, int playerAmountInput) {
        teamAmount = teamAmountInput;
        playerAmount = playerAmountInput;
        setStage();
    }

    private void setStage() {
        secondaryStage = new Stage();
        secondaryStage.setTitle("Bowling Score Calculator");
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
        Accordion playerDisplay = new Accordion();
        for (int i = 0; i < playerAmount; i++) {
            int playerNumber = i + 1;
            playerDisplay.getPanes().add(createPlayerPane("../view/playerpane.fxml", "Player " + playerNumber));
        }
        return new Tab(name, playerDisplay);
    }

    private TitledPane createPlayerPane(String filePath, String paneName) {
        readFXML(filePath);
        return new TitledPane(paneName, basicPlayer.lookup("GridPane"));
    }

    private void readFXML(String filePath) {
        try {
            basicPlayer = FXMLLoader.load(getClass().getResource(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getSecondaryStage() {
        return secondaryStage;
    }
}
