module com.example.lab03 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens ua.bondarenko.lab03 to javafx.fxml;
    exports ua.bondarenko.lab03;
}