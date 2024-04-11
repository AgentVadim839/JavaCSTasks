package ua.bondarenko.lab01;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label failLabel;
    @FXML
    private Label actionLabel;
    @FXML
    private TextField num1;
    @FXML
    private TextField num2;
    @FXML
    private TextField resultField;
    @FXML
    private Button buttonSum;
    @FXML
    private Button buttonMinus;
    @FXML
    private Button buttonMultiplier;
    @FXML
    private Button buttonDevider;
    @FXML
    private Button button3;

    private int dx = -5;
    private int dy = -5;
    private int x;
    private int y;



    @FXML
    protected void butt3Moved() {
        x = (int) button3.getLayoutX();
        y = (int) button3.getLayoutY();

        if (x > HelloApplication.stage.getWidth() - button3.getWidth() - 10 || x < 10) {
            dx *= -1;
        }
        if (y > HelloApplication.stage.getHeight() - button3.getHeight() - 30 || y < 10) {
            dy *= -1;
        }

        // Перемещаем кнопку
        button3.setLayoutX(button3.getLayoutX() + dx);
        button3.setLayoutY(button3.getLayoutY() + dy);
    }

    @FXML
    protected void makeSum() {
        try {
            int numm1 = Integer.parseInt(num1.getText());
            int numm2 = Integer.parseInt(num2.getText());
        } catch (NumberFormatException n) {
            failLabel.setText("TYPE A NUM!!!11");
        }

        int numm1 = Integer.parseInt(num1.getText());
        int numm2 = Integer.parseInt(num2.getText());
        actionLabel.setText("+");
        resultField.setText((numm1+numm2)+"");
        failLabel.setText("");
    }
    public void makeMinus() {
        try {
            int numm1 = Integer.parseInt(num1.getText());
            int numm2 = Integer.parseInt(num2.getText());
        } catch (NumberFormatException n) {
            failLabel.setText("TYPE A NUM!!!11");
        }
        int numm1 = Integer.parseInt(num1.getText());
        int numm2 = Integer.parseInt(num2.getText());
        actionLabel.setText("-");
        resultField.setText((numm1-numm2)+"");
        failLabel.setText("");
    }

    public void makeDevide() {
        try {
            int numm1 = Integer.parseInt(num1.getText());
            int numm2 = Integer.parseInt(num2.getText());
        } catch (NumberFormatException n) {
            failLabel.setText("TYPE A NUM!!!11");
        }
        int numm1 = Integer.parseInt(num1.getText());
        int numm2 = Integer.parseInt(num2.getText());
        actionLabel.setText("/");
        resultField.setText((numm1/numm2)+"");
        failLabel.setText("");
    }

    public void makeMultiply() {
        try {
            int numm1 = Integer.parseInt(num1.getText());
            int numm2 = Integer.parseInt(num2.getText());
        } catch (NumberFormatException n) {
            failLabel.setText("TYPE A NUM!!!11");
        }
        int numm1 = Integer.parseInt(num1.getText());
        int numm2 = Integer.parseInt(num2.getText());
        actionLabel.setText("*");
        resultField.setText((numm1*numm2)+"");
        failLabel.setText("");
    }
}