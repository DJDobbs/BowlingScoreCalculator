package edu.bsu.cs222.view;

import edu.bsu.cs222.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {
    private Player player = new Player();

    @FXML
    public Text currentTotalScore;
    public Text currentScore;
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
        currentScore.setText(toString(input));
        currentTotalScore.setText(String.valueOf(calculateTotalScore()));
    }

    private int calculateTotalScore() {
        addPinScore();
        int total = player.getScore();
        return total;
    }

    private void addPinScore(){
        try {
            player.addRoll(toInteger(input));
        }catch (ArrayIndexOutOfBoundsException e){
            e.getMessage();
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
        Stage stage = new CustomizedStage(toInteger(teamAmount), toInteger(playerAmount)).getStage();
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
