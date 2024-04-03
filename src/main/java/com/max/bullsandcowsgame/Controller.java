package com.max.bullsandcowsgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Objects;

import static com.max.bullsandcowsgame.SettingsVariables.*;


public class Controller {
    @FXML
    public TextField userGuess;
    @FXML
    public TableView<Result> resultTable;
    public int triesCount = 0;
    @FXML
    public Button go;

    @FXML
    public BorderPane body;
    // Check the user entering a number or string
    public void initialize() {
        userGuess.textProperty().addListener((obs, oldText, newText) -> {
            if (newText.length() > 4 || !newText.matches("\\d*") || newText.startsWith("0") ||
                    newText.matches(".*(.).*\\1")) {
                userGuess.setText(oldText);
            }
        });
        resultTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        resultTable.getColumns().forEach(column -> column.setReorderable(false));
    }

    // Create a new table entry and check if the user has been guessed the number
    public void go(ActionEvent actionEvent) {
        try {
            String guess = userGuess.getText();

            if (guess.length() != 4) throw new InvalidInputException(guess);

            int bullsCount = PickedNumber.findBulls(guess);
            int cowsCount = PickedNumber.findCows(guess);
            triesCount++;

            Result result = new Result();
            result.setGuess(guess);
            result.setTries(triesCount);
            result.setBulls(bullsCount);
            result.setCows(cowsCount);
            resultTable.getItems().add(result);

            if (bullsCount == 4) {
                System.out.println("You has been guessed the number! It's was " + PickedNumber.getPickedNumber());

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("guessed-window.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();

                    GuessedController guessedController = fxmlLoader.getController();
                    guessedController.addText(PickedNumber.getPickedNumber(), triesCount);

                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);

                    stage.setTitle("Congratulations!");
                    stage.getIcons().add(new Image(Objects.requireNonNull(App.class.getResourceAsStream("images/icon_bull_512.png"))));
                    stage.setMinWidth(minWidthAdditional);
                    stage.setMinHeight(minHeightAdditional);
                    stage.setMaxWidth(maxWidthAdditional);
                    stage.setMaxHeight(maxHeightMainAdditional);
                    stage.setWidth(minWidthMain);
                    stage.setHeight(minHeightMain);

                    Scene scene = new Scene(root1);
                    scene.getStylesheets().add(App.class.getResource("styles.css").toExternalForm());

                    stage.setScene(scene);
                    stage.showAndWait();
                } catch(Exception e) {
                    e.printStackTrace();
                }

                PickedNumber.generatePickedNumber();
                triesCount = 0;

                System.out.println(PickedNumber.getPickedNumber());
            }
        }
        catch (InvalidInputException exception) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("errors-window.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();

                ErrorsController errorsController = fxmlLoader.getController();
                errorsController.addTextArea(exception.getMessage());

                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);

                stage.setTitle("Errors");
                stage.getIcons().add(new Image(Objects.requireNonNull(App.class.getResourceAsStream("images/icon_bull_512.png"))));
                stage.setMinWidth(minWidthAdditional);
                stage.setMinHeight(minHeightAdditional);
                stage.setMaxWidth(maxWidthAdditional);
                stage.setMaxHeight(maxHeightMainAdditional);
                stage.setWidth(minWidthAdditional);
                stage.setHeight(minHeightAdditional);

                Scene scene = new Scene(root1);
                scene.getStylesheets().add(App.class.getResource("styles.css").toExternalForm());

                stage.setScene(scene);
                stage.showAndWait();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}