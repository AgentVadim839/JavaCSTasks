module org.example.randompassword {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.bondar.randompassword to javafx.fxml;
    exports org.bondar.randompassword;
}