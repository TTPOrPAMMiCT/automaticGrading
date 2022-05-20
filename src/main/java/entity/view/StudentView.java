package entity.view;

import entity.model.Grade;
import entity.model.Student;
import entity.model.StudentGroup;
import javafx.scene.control.Button;

import java.util.List;

public class StudentView extends Student {
    private Button button = new Button("Удалить");
    private double average;
    private int averageScore;

    StudentGroup studentGroup;
    List<Grade> gradeList;

    public void createStudent(StudentGroup studentGroup, Student student, List<Grade> gradeList) {
        setId(student.getId());
        setName(student.getName());
        setSurname(student.getSurname());
        setMiddleName(student.getMiddleName());
        setStudentGroup(studentGroup);
        setGradeList(gradeList);
    }

    private void countUpAverage(List<Grade> gradeList) {
        double number = 0;
        if(gradeList.size() != 0) {
            for (int i = 0; i < gradeList.size(); i++) {
                number = number + gradeList.get(i).getGrade();
            }
            setAverage(number / gradeList.size());
            setAverageScore((int) Math.round(number / gradeList.size()));
        }
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }
}
