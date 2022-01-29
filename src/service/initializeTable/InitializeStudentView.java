package service.initializeTable;

import dao.gradeDao.GradeDaoImpl;
import dao.studentDao.StudentDaoImpl;
import entity.model.Student;
import entity.view.StudentView;

import java.util.ArrayList;
import java.util.List;

public class InitializeStudentView {

    public List<StudentView> initializeStudentView(int idGroup) {
        List<StudentView> studentViewList = new ArrayList<>();
        StudentDaoImpl studentDao = new StudentDaoImpl();
        GradeDaoImpl gradeDao = new GradeDaoImpl();
        List<Student> studentList = studentDao.findStudents(idGroup);
        for (int i = 0; i < studentList.size(); i++) {
            studentViewList.add(new StudentView(
                    studentList.get(i),
                    gradeDao.findGrade(studentList.get(i).getId()),
                    i));
        }
        return studentViewList;
    }

    /*public static void main(String[] args) {
        InitializeStudentView initializeStudentView = new InitializeStudentView();
        initializeStudentView.initializeStudentView(0);
    }*/
}

