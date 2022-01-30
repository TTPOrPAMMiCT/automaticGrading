package entity.view;

import dao.gradeDao.GradeDao;
import dao.gradeDao.GradeDaoImpl;
import dao.studentDao.StudentDao;
import dao.studentDao.StudentDaoImpl;
import entity.model.Grade;
import entity.model.Student;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;
import java.util.List;

public class StudentView extends Student {
    Button deleteStudent = new Button("удалить");
    int idLine;
    List<Grade> gradeList;
    int averageScore;
    String gradesString;

    public StudentView(Student student, List<Grade> grade, int idLine) {
        setId(student.getId());
        setName(student.getName());
        setSurname(student.getSurname());
        setMiddleName(student.getMiddleName());
        setIdGroup(student.getIdGroup());
        setGradeList(grade);
        setIdLine(idLine);
        calculatedAverageScore(grade);
        gradesToString(gradeList);
    }

    public StudentView() {
    }

    //////////////////////////////////////REALISE METHOD///////////////////////////////////////////////

    private void clickDeleteStudent() {
        deleteStudent.setOnAction(event -> {
            StudentDao studentDao = new StudentDaoImpl();
            studentDao.deleteStudent(getId());
            GradeDao gradeDao = new GradeDaoImpl();
            gradeDao.deleteFullGrades(getId());
        });
    }

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

    public int getIdLine() {
        return idLine;
    }

    public void setIdLine(int idLine) {
        this.idLine = idLine;
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
                "idLine=" + idLine +
                ", gradeList=" + gradeList +
                '}' + getStudent();
    }
}
