package ua.bondarenko.lab03.Person;

public class Student {
    private String name;
    private int diaryNum;
    private double averageGrade;

    public Student(String name, int diaryNum, double averageGrade) {
        this.name = name;
        this.diaryNum = diaryNum;
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return name  + " " + diaryNum + " " + averageGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiaryNum() {
        return diaryNum;
    }

    public void setDiaryNum(int diaryNum) {
        this.diaryNum = diaryNum;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }




}
