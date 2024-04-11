package ua.bondarenko.lab03;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ua.bondarenko.lab03.List.StudentList;
import ua.bondarenko.lab03.Person.Student;
import ua.bondarenko.lab03.Services.DelayExecuter;

public class StudentManagerController {

    public TextField nameField;
    public TextField markDiary;
    public TextField averageMarkField;
    public TextArea infoArea;
    public Label infoLabel;

    Runnable returnNormal = () -> Platform.runLater(() -> {
        infoLabel.setText("Оберіть операцію.");
    });

    private String name;
    private int diaryNum;
    private double avgGrade;

    StudentList listStudent = new StudentList();

    public void addInList(ActionEvent actionEvent) {
        try {
            getStudentData();
            listStudent.addStudentInList(createStudent(name,diaryNum,avgGrade));
            clear();
            infoLabel.setText("Додано успішно!");
            waitAndReturnNormal();
        } catch (Exception e) {
            infoLabel.setText("Невірні дані!");
            waitAndReturnNormal();
        }
    }

    public void addByPlace(ActionEvent actionEvent) {
        try {
            getStudentData();
            Student sdt = createStudent(name,diaryNum,avgGrade);
            listStudent.addStudentByDiaryNumber(sdt, sdt.getDiaryNum());
            clear();
            infoLabel.setText("Додано успішно!");
            waitAndReturnNormal();
        } catch (Exception e) {
            infoLabel.setText("Невірні дані!");
            waitAndReturnNormal();
        }
    }


    public void showAll(ActionEvent actionEvent) {
        clearInfoArea();
        for(Student std : listStudent.showAllStudents()) {
            int number = listStudent.showAllStudents().indexOf(std) + 1;
            infoArea.appendText(number + ". " + std.getName() + " " + std.getAverageGrade() + " " + std.getDiaryNum() + "\n");
        }

    }

    public void avgMoreThanFour(ActionEvent actionEvent) {
        clearInfoArea();
        for(Student std:listStudent.getStudentWithMarkMoreThanFour()) {
            int number = listStudent.showAllStudents().indexOf(std) + 1;
            infoArea.appendText(number + ". " + std.getName() + " " + " " + std.getAverageGrade() + " " + std.getDiaryNum() + "\n");
        }
    }

    public void showFirstElement(ActionEvent actionEvent) {
        clearInfoArea();
        infoArea.appendText("1. "+listStudent.getFirstStudent());
    }

    public void showAndDeleteFirstElement(ActionEvent actionEvent) {
        clearInfoArea();
        infoArea.appendText("1. "+listStudent.showAndDeleteFirstStudent());
    }

    public void showLastElement(ActionEvent actionEvent) {
        clearInfoArea();
        int number = listStudent.showAllStudents().size();
        infoArea.appendText(number + ". " + listStudent.getLastStudent());
    }

    public void showAndDeleteLastElement(ActionEvent actionEvent) {
        clearInfoArea();
        int number = listStudent.showAllStudents().size();
        infoArea.appendText(number + ". " + listStudent.getLastAndRemoveStudent());
    }

    public void findByMarkBookNumber(ActionEvent actionEvent) {
        try {
            clearInfoArea();
            int number = listStudent.showAllStudents().indexOf(listStudent.findByDiaryNumber(Integer.parseInt(markDiary.getText()))) + 1;
            infoArea.appendText(number + ". " + listStudent.findByDiaryNumber(Integer.parseInt(markDiary.getText())));
        } catch (Exception e) {
            infoLabel.setText("Не знайдено за таким номером.");
            waitAndReturnNormal();
        }
    }

    private void clear() {
        nameField.setText("");
        markDiary.setText("");
        averageMarkField.setText("");
    }

    private void getStudentData() {
        name = nameField.getText().trim();
        diaryNum = Integer.parseInt(markDiary.getText());
        avgGrade = Double.parseDouble(averageMarkField.getText());
    }

    private Student createStudent(String name, int diaryNum, double avgGrade) {
        Student student = new Student(name, diaryNum, avgGrade);
        return student;
    }
    private void clearInfoArea() { infoArea.setText("");}
    private void waitAndReturnNormal() {
        DelayExecuter.executeAfterDelay(2, returnNormal, 2);
    }
}