package entity.view;

import entity.model.Grade;
import entity.model.Student;
import entity.model.StudentGroup;
import javafx.scene.control.Button;

import java.util.List;

public class StudentView extends Student {
    private Button deleteStudent = new Button("удалить");
    private List<Grade> gradeList;
    private int averageScore;
    private String gradesString;
    private String strStudentGroup;
    private StudentGroup studentGroup;
    private int idLine;

    public StudentView() {
    }

    public void createStudent(Student student, StudentGroup studentGroup, List<Grade> gradeList) {
        setId(student.getId());
        setName(student.getName());
        student.setSurname(student.getSurname());
        student.setMiddleName(student.getMiddleName());
        setStudentGroup(studentGroup);
        setGradeList(gradeList);
    }


    private void initStudentTable(Student student){

    }

    private void parseStringGroup() {
        setStrStudentGroup(getStudentGroup().toString());
    }

    ///////////////////////

    private void calculatedAverageScore(List<Grade> gradeList) {
        double average = 0.0;
        for (int i = 0; i < gradeList.size(); i++) {
            average += gradeList.get(i).getGrade();
        }
        this.averageScore = (int) Math.round(average / gradeList.size());
    }

    private void gradesToString(List list) {
        String convertString = list.toString();
        this.gradesString = convertString.replaceAll("[\\[\\]]", "");;
    }

    ///////////////////////////////////////Getters and Setters///////////////////////////////////////


    public int getIdLine() {
        return idLine;
    }

    public void setIdLine(int idLine) {
        this.idLine = idLine;
    }

    public String getStrStudentGroup() {
        return strStudentGroup;
    }

    public void setStrStudentGroup(String strStudentGroup) {
        this.strStudentGroup = strStudentGroup;
    }

    public Button getDeleteStudent() {
        return deleteStudent;
    }

    public void setDeleteStudent(Button deleteStudent) {
        this.deleteStudent = deleteStudent;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public String getGradesString() {
        return gradesString;
    }

    public void setGradesString(String gradesString) {
        this.gradesString = gradesString;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    @Override
    public String toString() {
        return "StudentView{" +
                ", gradeList=" + gradeList +
                '}';
    }
}
