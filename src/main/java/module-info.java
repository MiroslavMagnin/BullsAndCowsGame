module com.max.bullsandcowsgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;
    requires java.desktop;
    requires org.jdom2;


    opens com.max.bullsandcowsgame to javafx.fxml;
    exports com.max.bullsandcowsgame;
}