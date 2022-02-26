package entity.view;

import controllers.Controller;
import dao.gradeDao.GradeDao;
import dao.gradeDao.GradeDaoImpl;
import dao.studentDao.StudentDao;
import dao.studentDao.StudentDaoImpl;
import dao.studentGroupDao.StudentGroupDao;
import dao.studentGroupDao.StudentGroupDaoImpl;
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

    public StudentView(Student student, int idLine) {
        setName(student.getName());
        setSurname(student.getSurname());
        setMiddleName(student.getMiddleName());
        setId(student.getId());
        setIdGroup(student.getIdGroup());
        setIdLine(idLine);
        initStudentTable(student);
    }

    /////////////////////////////////button

    private void initialiseDeleteStudent () {
        StudentDao studentDao = new StudentDaoImpl();
        deleteStudent.setOnAction(event -> {
            studentDao.deleteStudent(getId());
            Controller.getMainWindowController().updateTableContent();
            Controller.getMainWindowController().getEditListStudentController().updateTableContent();
        });
    }

    ///////////////////////////////////////

    ///////////////////init

    private void initStudentTable(Student student){
        StudentGroupDao studentGroupDao = new StudentGroupDaoImpl();
        GradeDao gradeDao = new GradeDaoImpl();
        setGradeList(gradeDao.findGrade(student.getId()));
        setStudentGroup(studentGroupDao.findGroupFromId(student.getId()));
        calculatedAverageScore(getGradeList());
        gradesToString(getGradeList());
        parseStringGroup();
        initialiseDeleteStudent();
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
                '}' + getStudent();
    }
}
