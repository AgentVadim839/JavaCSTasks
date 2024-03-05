package ua.me.lab02;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ua.me.lab02.logic.Apple;
import ua.me.lab02.logic.Logic;
import ua.me.lab02.logic.LogicImplementation;

import javax.security.auth.login.LoginException;
import java.util.List;

public class AppController {

    Logic logic = new LogicImplementation();

    public TextField nameField;
    public TextField priceField;
    public Label taskStatus;
    public Label dataError;
    public TextArea appleList;

    public void buttonAdd() {
        try {
            String name = nameField.getText();
            int price = Integer.parseInt(priceField.getText());
            Apple apple = new Apple(name, price);
            boolean result = logic.add(apple);
            if (result) {
                taskStatus.setText("Додано успішно!");
            } else {
                taskStatus.setText("Успішно не додано!");
            }
        } catch (Exception e) {
            taskStatus.setText("F");
            dataError.setVisible(true);
        }
    }

    public void getAllButton () {
        appleList.setText("");
        List<Apple>list=logic.getAll();
        for(Apple apple:list){
            appleList.appendText(apple.getName()+"\t"+apple.getPrice()+"\n");
        }
    }

    public void morePriceButton(ActionEvent actionEvent) {
        appleList.setText("");
        List<Apple>list=logic.getAllPriceMore(15);
        for(Apple apple:list){
            appleList.appendText(apple.getName()+"\t"+apple.getPrice()+"\n");
        }
    }
}