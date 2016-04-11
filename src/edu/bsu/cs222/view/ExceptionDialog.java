package edu.bsu.cs222.view;

import javafx.scene.control.Alert;

public class ExceptionDialog {
    private Alert exceptionAlert;

    public ExceptionDialog(String warning) {
        exceptionAlert = new Alert(Alert.AlertType.INFORMATION);
        exceptionAlert.setTitle("Warning");
        exceptionAlert.setHeaderText(null);
        exceptionAlert.setContentText(warning);
        exceptionAlert.showAndWait();
    }
}
