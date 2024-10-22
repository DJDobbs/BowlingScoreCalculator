package edu.bsu.cs222.view;

import edu.bsu.cs222.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {
    private Player player = new Player();
    private int total = 0;
    private int frame = 0;

    @FXML
    public Text currentTotalScore;
    public Text currentScore;
    public Text currentFrame;
    public ChoiceBox input;
    public ChoiceBox teamAmount;
    public ChoiceBox playerAmount;

    @FXML
    protected void handleAddButtonAction(ActionEvent event) {
        setOutput();
    }

    @FXML
    protected void handleKeyboardAction(KeyEvent keyboard) {
        if (keyboard.getCode().equals(KeyCode.ENTER)) {
            setOutput();
        }
    }

    private void setOutput() {
        calculateTotalScore();
        currentScore.setText(toString(input));
        currentTotalScore.setText(String.valueOf(total));
        currentFrame.setText(String.valueOf(frame));
    }

    private void calculateTotalScore() {
        addPinScore();
        total = player.getPlayerScore();
        frame = player.getCurrentPlayerFrame();
    }

    private void addPinScore() {
        try {
            player.addNewBall(toInteger(input));
        } catch (ArrayIndexOutOfBoundsException e) {
            ExceptionDialog warning = new ExceptionDialog("You input " + e.getMessage() + " times.");
        }
    }

    private String toString(ChoiceBox cb) {
        String number = cb.getSelectionModel().getSelectedItem().toString();
        return number;
    }

    private int toInteger(ChoiceBox cb) {
        int intNumber = Integer.parseInt(toString(cb));
        return intNumber;
    }

    @FXML
    protected void handleCreateButtonAction(ActionEvent event) {
        try {
            Stage stage = new CustomizedStage(toInteger(teamAmount), toInteger(playerAmount)).getSecondaryStage();
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (NullPointerException e) {
            e.getMessage();
            ExceptionDialog warning = new ExceptionDialog("Please choose player amount and team amount.");
        }
    }
}
