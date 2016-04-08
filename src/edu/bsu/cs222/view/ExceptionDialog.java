package edu.bsu.cs222.view;

import javafx.scene.control.Alert;

public class ExceptionDialog {

    private Alert alert;

    public ExceptionDialog(String warning) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(warning);
        alert.showAndWait();
    }

}
