module com.learning.chess.chess {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.learning.chess to javafx.fxml;
    exports com.learning.chess;
}