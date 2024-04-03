package com.max.bullsandcowsgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ErrorsController {
    @FXML
    public TextArea errorsArea;
    @FXML
    public Button closeButton;

    public void addTextArea(String text) {
        errorsArea.setText(text);
        errorsArea.setEditable(false);
    }

    public void errorsClose(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
