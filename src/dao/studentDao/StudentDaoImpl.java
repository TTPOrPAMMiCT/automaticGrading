package dao.studentDao;


import utility.dataBase.ConnectDB;
import entity.model.Student;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends StudentDao {
    ConnectDB connectDB =  new ConnectDB();

    @Override
    public List<Student> findStudents(int idGroup) {
        List<Student> studentList = new ArrayList<>();
        try {
            Statement statement = connectDB.returnConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student where student.groupId = " + idGroup);
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

    /*public static void main(String[] args) {
        StudentDaoImpl dao = new StudentDaoImpl();
        System.out.println(dao.findStudents(0));
    }*/
}
