package ua.me.lab02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ua.me.lab02.logic.FileMonitoring;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("app.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("AYYOOOOO THIS IS SUPER APPLE APP YEE");
        stage.setScene(scene);
        stage.show();
        FileMonitoring.deleteFileIfOlderThan();
    }

    public static void main(String[] args) {
        launch();
    }
}