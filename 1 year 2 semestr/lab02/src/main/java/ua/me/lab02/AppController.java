package ua.me.lab02;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ua.me.lab02.logic.Apple;
import ua.me.lab02.logic.DelayExecuter;
import ua.me.lab02.logic.Logic;
import ua.me.lab02.logic.LogicImplementation;

import java.util.List;

public class AppController {

    Logic logic = new LogicImplementation();

    Runnable task = () -> Platform.runLater(() -> {
        this.taskStatus.setText("Оберіть операцію.");
        this.dataError.setVisible(false);
    });

    public TextField numberField;
    public TextField nameField;
    public TextField priceField;
    public Label taskStatus;
    public Label dataError;
    public TextArea appleList;

    public void buttonAdd() {
        numberField.setText("");
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
        nameField.setText("");
        priceField.setText("");
        DelayExecuter.executeAfterDelay(1, task, 3);
    }

    public void getAllButton () {
        numberField.setText("");
        if(logic.getAll().isEmpty()) {
            taskStatus.setText("Список пустий.");
            DelayExecuter.executeAfterDelay(2, task, 2);
        }
        appleList.setText("");
        List<Apple>list=logic.getAll();
        for(Apple apple:list){
            int i = logic.getAll().indexOf(apple) + 1;
            appleList.appendText(i +". " + apple.getName()+"  "+apple.getPrice()+"\n");
        }
    }

    public void morePriceButton() {
        numberField.setText("");
        if(logic.getAll().isEmpty() || logic.getAllPriceMore(15).isEmpty()) {
            taskStatus.setText("Список пустий.");
            DelayExecuter.executeAfterDelay(3, task, 2);
        }
        appleList.setText("");
        List<Apple>list=logic.getAllPriceMore(15);
        for(Apple apple:list){
            int i = logic.getAll().indexOf(apple) + 1;
            appleList.appendText(i +". " + apple.getName()+"  "+apple.getPrice()+"\n");
        }
    }

    public void buttonFindByNumber() {
        appleList.setText("");
        numberField.setText("");
        try {
            int searchNumber = Integer.parseInt(numberField.getText());
            Apple result = logic.getByNumber(searchNumber);
            appleList.appendText(searchNumber+ ". " + result.getName()+"  "+result.getPrice()+"\n");
        } catch (Exception e) {
            taskStatus.setText("F");
            dataError.setVisible(true);
            taskStatus.setText("Немає яблука з таким номером!");
            DelayExecuter.executeAfterDelay(4, task, 3);
        }

    }

    public void clearButton(ActionEvent actionEvent) {
        numberField.setText("");
        logic.removeAll();
        taskStatus.setText("Список відчищено.");
        appleList.setText("");
        DelayExecuter.executeAfterDelay(5, task, 3);

    }

    public void lessPriceButton(ActionEvent actionEvent) {
        numberField.setText("");
        if(logic.getAll().isEmpty() || logic.getAllPriceLess(15).isEmpty()) {
            taskStatus.setText("Список пустий.");
            DelayExecuter.executeAfterDelay(3, task, 2);
        }
        appleList.setText("");
        List<Apple>list=logic.getAllPriceLess(15);
        for(Apple apple:list){
            int i = logic.getAll().indexOf(apple) + 1;
            appleList.appendText(i +". " + apple.getName()+"  "+apple.getPrice()+"\n");
        }
    }
}
