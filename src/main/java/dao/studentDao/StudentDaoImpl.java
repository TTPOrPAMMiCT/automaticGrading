package dao.studentDao;


import dao.gradeDao.GradeDao;
import dao.gradeDao.GradeDaoImpl;
import entity.model.StudentGroup;
import entity.view.StudentView;
import utility.dataBase.ConnectDB;
import entity.model.Student;

import java.security.acl.Group;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends StudentDao {
    ConnectDB connectDB =  new ConnectDB();

    @Override
    public List<StudentView> findStudents() {
        List<StudentView> studentList = new ArrayList<>();
        int line = 1;
        try {
            Statement statement = connectDB.returnConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student;");
            while (resultSet.next()) {
                studentList.add(new StudentView(new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                        ), line));
                line++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public List<StudentView> findStudentsFromId(StudentGroup studentGroup) {
        List<StudentView> studentList = new ArrayList<>();
        int line = 1;
        try {
            Statement statement = connectDB.returnConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student where group_id = " + studentGroup.getId() + ";");
            while (resultSet.next()) {
                studentList.add(new StudentView(new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                ), line));
                line++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void deleteStudent(int idStudent) {
        Statement statement = null;
        GradeDao gradeDao = new GradeDaoImpl();
        try {
            statement = connectDB.returnConnection().createStatement();
            gradeDao.deleteFullGrades(idStudent);
            int countDelete = statement.executeUpdate("DELETE FROM student WHERE id = " + idStudent + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudentFromGroup(StudentGroup studentGroup) {
        Statement statement = null;
        try {
            statement = connectDB.returnConnection().createStatement();
            int countDelete = statement.executeUpdate("DELETE FROM student WHERE group_id = " + studentGroup.getId() + ";");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(StudentView studentView) {
        Statement statement = null;
        try {
            String url = "UPDATE student " +
                    " SET" +
                    " `name` = ' " + studentView.getName() + "' ," +
                    " `surname` = ' " + studentView.getSurname() + "'," +
                    " `middle_name` = '" + studentView.getMiddleName() + "'," +
                    " `group_id` = ' " + studentView.getIdGroup() + "'" +
                    " WHERE" +
                    " (id = " + studentView.getId() + ");";
            statement = connectDB.returnConnection().createStatement();
            int resultSet = statement.executeUpdate(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addStudent(Student student) {
        try {
            PreparedStatement preparedStatement = connectDB
                    .returnConnection()
                    .prepareStatement("insert into student(name, surname, middle_name, group_id) values (?,?,?,?)");

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getMiddleName());
            preparedStatement.setInt(4, student.getIdGroup());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
