module ua.me.lab02 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.apache.logging.log4j;

    opens ua.me.lab02 to javafx.fxml;
    exports ua.me.lab02;
}