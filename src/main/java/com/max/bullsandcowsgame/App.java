package com.max.bullsandcowsgame;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.max.bullsandcowsgame.SettingsVariables.*;

public class App extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        PickedNumber.generatePickedNumber();
        System.out.println(PickedNumber.getPickedNumber());

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-window.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), widthMain, heightMain);
        scene.getStylesheets().add(App.class.getResource("styles.css").toExternalForm());
        setSizeMainWindow(stage);
        stage.setTitle("Bulls and Cows Game");
        stage.getIcons().add(new Image(Objects.requireNonNull(App.class.getResourceAsStream("images/icon_cow_512.png"))));

        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            // Save to XML-file the last main window size
            settingsManager.setSetting("defaultWidthMainWindow", String.valueOf(stage.getWidth()));
            settingsManager.setSetting("defaultHeightMainWindow", String.valueOf(stage.getHeight()));
            settingsManager.setSetting("isMaximizedMainWindow", String.valueOf(stage.isMaximized()));
        });
    }

    public void setSizeMainWindow(Stage stage) {
        stage.setMinWidth(minWidthMain);
        stage.setMinHeight(minHeightMain);
        stage.setMaximized(isMaximized);

        // Get screen (monitor) size
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        if (widthMain > primaryScreenBounds.getMaxX() || heightMain > primaryScreenBounds.getMaxY()) {
            stage.setMaximized(true);
        }
    }
}