package com.max.bullsandcowsgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GuessedController {

    @FXML
    public TextArea successfulText;
    @FXML
    public Button closeButton;
    public BorderPane guessedBody;

    public void addText(String number, int triesCount) {
        successfulText.setText("Congratulations! You've guessed the number " + number + " in " + triesCount + " tries");
        successfulText.setEditable(false);
    }

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
