package ua.bondarenko.lab03.List;

import ua.bondarenko.lab03.Person.Student;

import java.util.LinkedList;
import java.util.List;

public class StudentList {
    List<Student> studentList = new LinkedList<Student>();

    public void addStudentInList(Student student) {
        studentList.add(student);
    }

    public List<Student> addStudentByDiaryNumber(Student student, int place) {
        studentList.add(place, student);
        return studentList;
    }

    public List<Student> showAllStudents() {
        return studentList;
    }

    public List<Student> getStudentWithMarkMoreThanFour() {
        List temporList = new LinkedList<Student>();
        for(Student stud : studentList) {
            if(stud.getAverageGrade()>=4) {
                temporList.add(stud);
            }
        }
        return temporList;
    }

    public Student getFirstStudent() {
        return studentList.get(0);
    }

    public Student showAndDeleteFirstStudent() {
        Student stud = studentList.get(0);
        studentList.remove(0);
        return stud;
    }

    public Student getLastStudent() {
        int index = studentList.size()-1;
        return studentList.get(index);
    }

    public Student getLastAndRemoveStudent() {
        int index = studentList.size()-1;
        Student stud = studentList.get(index);
        studentList.remove(index);
        return stud;
    }

    public Student findByDiaryNumber(int number) {
        List<Student> temporList = new LinkedList<Student>();
        for(Student stud: studentList) {
            if(stud.getDiaryNum() == number)
                return stud;
        }
        return null;
    }
}
