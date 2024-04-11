package org.bondar.randompassword;

import Services.FileServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomPasswordController {
    public Label charactersCount;
    public Slider slider;
    public TextField resultField;
    public Label passwordCheckLabel;

    private int sliderValue = 2;

    public void sliderMoved(MouseEvent mouseEvent) {
        sliderValue = (int)slider.getValue();
        charactersCount.setText((int)slider.getValue() + "");
    }

    public void degeneratePressed(ActionEvent actionEvent) {
        boolean goodPassword = false;
        String output = "";
        String symbols = "AaBbCcDdEeFfGgHhIiJjKkLl1234567890!#$%&MmNnOoPpQDdEeFfGgHqRrSsTtUuVvWwXxYyZz";
        Random rand = new Random();
        for (int i = 0; i < sliderValue; i++) {
            output += symbols.charAt(rand.nextInt(symbols.length()));
        }

        resultField.setText(output);

    }

    public void copyPassword(ActionEvent actionEvent) {
        String text = resultField.getText();
        if (!text.isEmpty()) {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(text);
            clipboard.setContent(content);
        }
    }

    public void saveToFile(ActionEvent actionEvent) {
        String text = resultField.getText();
        FileServices filer = new FileServices();
        filer.setFilePath("C:\\Users\\Olaf\\Desktop\\");
        filer.setFileName("passwords.txt");
        filer.writeFile(text);
    }
}