package ua.me.lab02;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ua.me.lab02.logic.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AppController {

    public TextField numberField;
    public TextField nameField;
    public TextField priceField;
    public Label taskStatus;
    public Label dataError;
    public TextArea appleList;

    private static final Logger logger = LogManager.getLogger("FirstLogger");

    Logic logic = new LogicImplementation();

    private Apple initializeApple() {
        String name = nameField.getText();
        int price = Integer.parseInt(priceField.getText());
        Apple apple = new Apple(name, price);
        return apple;
    }


    private void returnDefaultTextFields() {
        nameField.setText("");
        priceField.setText("");
        DelayExecuter.executeAfterDelay(1, task, 3);
    }


    Runnable task = () -> Platform.runLater(() -> {
        this.taskStatus.setText("Оберіть операцію.");
        this.dataError.setVisible(false);
    });

    private void soSad() {
        taskStatus.setText("F");
        dataError.setVisible(true);
        taskStatus.setText("Немає яблука з таким номером!");
        logger.error("Failed to find apple with this number");
        DelayExecuter.executeAfterDelay(4, task, 3);
        numberField.setText("");
    }


    public void buttonAdd() {
        numberField.setText("");

        try {
            Apple apple = initializeApple();
            boolean result = logic.add(apple);
            if (result) {
                taskStatus.setText("Додано успішно!");
                logger.info("Apple added to the list");
            } else {
                taskStatus.setText("Успішно не додано!");
            }
        } catch (Exception e) {
            logger.error("Error on adding apple to the list");
            taskStatus.setText("Невірні введені дані!");
            dataError.setVisible(true);
        }
        returnDefaultTextFields();
    }

    public void getAllButton () {
        numberField.setText("");
        if(logic.getAll().isEmpty()) {
            taskStatus.setText("Список пустий.");
            logger.info("The list is empty");
            DelayExecuter.executeAfterDelay(2, task, 2);
        } else {
            appleList.setText("");
            List<Apple> list = logic.getAll();
            logger.info("Apples were showed on the Text Area");
            for (Apple apple : list) {
                int i = logic.getAll().indexOf(apple) + 1;
                appleList.appendText(i + ". " + apple.getName() + "  " + apple.getPrice() + "\n");
            }
        }


    }

    public void morePriceButton() {
        numberField.setText("");
        if(logic.getAll().isEmpty() || logic.getAllPriceMore(15).isEmpty()) {
            taskStatus.setText("Список пустий.");
            logger.info("The list is empty");
            DelayExecuter.executeAfterDelay(3, task, 2);
        } else {
            appleList.setText("");
            List<Apple> list = logic.getAllPriceMore(15);
            logger.info("Apples were showed on the Text Area");
            for (Apple apple : list) {
                int i = logic.getAll().indexOf(apple) + 1;
                appleList.appendText(i + ". " + apple.getName() + "  " + apple.getPrice() + "\n");
            }
        }
    }

    public void buttonFindByNumber() {
        appleList.setText("");

        String numberText = numberField.getText().trim(); // Убираем лишние пробелы

        try {
            int searchNumber = Integer.parseInt(numberText);
            Apple result = logic.getByNumber(searchNumber);
            appleList.appendText(searchNumber + ". " + result.getName() + "  " + result.getPrice() + "\n");
            logger.info("Apple with №" + searchNumber + " was found");
        } catch (NumberFormatException e) {
            soSad();
        } catch (IndexOutOfBoundsException c) {
            soSad();
        }
    }



    public void clearButton(ActionEvent actionEvent) {
        numberField.setText("");
        logic.removeAll();
        taskStatus.setText("Список відчищено.");
        appleList.setText("");
        logger.info("The list was cleared");
        DelayExecuter.executeAfterDelay(5, task, 3);

    }

    public void lessPriceButton(ActionEvent actionEvent) {
        numberField.setText("");
        if(logic.getAll().isEmpty() || logic.getAllPriceLess(15).isEmpty()) {
            taskStatus.setText("Список пустий.");
            logger.info("The list is empty");
            DelayExecuter.executeAfterDelay(3, task, 2);
        } else {
            appleList.setText("");
            List<Apple> list = logic.getAllPriceLess(15);
            logger.info("Apples were showed on the Text Area");
            for (Apple apple : list) {
                int i = logic.getAll().indexOf(apple) + 1;
                appleList.appendText(i + ". " + apple.getName() + "  " + apple.getPrice() + "\n");
            }
        }
    }

    public void replaceButton(ActionEvent actionEvent) {
        String numberText = numberField.getText().trim();

        numberField.setText("");
        try {
            Apple apple = initializeApple();

            int num = Integer.parseInt(numberText);
            boolean result = logic.replace(apple, num);
            if (result) {
                taskStatus.setText("Успішно замінено яблуко №" + num + "!");
                logger.info("Apple №"+ num + " was successfully replaced");
            } else {
                taskStatus.setText("Не вгадали! Невірний номер, або ціна!");
            }
        } catch (Exception e) {
            logger.error("Invalid data values");
            taskStatus.setText("Невірний номер, або ціна з назвою!");
            dataError.setVisible(true);
        }
        returnDefaultTextFields();
    }


    public void addByNumber(ActionEvent actionEvent) {
        String numberText = numberField.getText().trim();

        numberField.setText("");
        try {
            Apple apple = initializeApple();

            int num = Integer.parseInt(numberText);
            boolean result = logic.addToPlace(apple, num);
            if (result) {
                taskStatus.setText("Успішно додано яблуко за №" + num + "!");
                logger.info("[replace] Apple №"+ num + " was successfully added");
            } else {
                taskStatus.setText("Все майже вийшло, але номер вже зайнятий!!!111111!11111");
            }
        } catch (IndexOutOfBoundsException e) {
            taskStatus.setText("Можна додавати тільки по порядку!!!11111!!111");
            logger.error("[addByNumber] Invalid number value");
            dataError.setVisible(true);
        } catch (NumberFormatException t) {
            taskStatus.setText("Неправильні дані ім'я/ціни.");
            logger.error("[addByNumber] Invalid data values");
            dataError.setVisible(true);
        }
        returnDefaultTextFields();

    }
}
