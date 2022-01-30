package dao.studentDao;


import utility.dataBase.ConnectDB;
import entity.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends StudentDao {
    ConnectDB connectDB =  new ConnectDB();

    @Override
    public List<Student> findStudents() {
        List<Student> studentList = new ArrayList<>();
        try {
            Statement statement = connectDB.returnConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student;");
            while (resultSet.next()) {
                studentList.add(new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void deleteStudent(int idStudent) {
        Statement statement = null;
        System.out.println(idStudent);
        try {
            statement = connectDB.returnConnection().createStatement();
            int countDelete = statement.executeUpdate("DELETE FROM student WHERE id = " + idStudent + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
