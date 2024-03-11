module ua.bondarenko.lab01 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens ua.bondarenko.lab01 to javafx.fxml;
    exports ua.bondarenko.lab01;
}