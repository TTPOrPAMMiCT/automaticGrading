package dao.studentGroupDao;

import dao.gradeDao.GradeDao;
import dao.gradeDao.GradeDaoImpl;
import dao.studentDao.StudentDao;
import dao.studentDao.StudentDaoImpl;
import utility.dataBase.ConnectDB;
import entity.model.StudentGroup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentGroupDaoImpl extends StudentGroupDao{
    ConnectDB connectDB = new ConnectDB();

    @Override
    public List findGroup() {
        List groupList = new ArrayList();
        try {
            String url = "select * from student_group";
            Statement statement = connectDB
                    .returnConnection()
                    .createStatement();
            ResultSet resultSet = statement.executeQuery(url);

            while (resultSet.next()) {
                groupList.add(new StudentGroup(
                        resultSet.getInt(1),
                        resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupList;
    }

    @Override
    public StudentGroup findGroupFromId(int id) {
        StudentGroup studentGroup = new StudentGroup();
        try {
            String url = "select * from student_group where id = " + id + ";";
            Statement statement = connectDB
                    .returnConnection()
                    .createStatement();
            ResultSet resultSet = statement.executeQuery(url);
            while (resultSet.next()) {
                studentGroup.setId(resultSet.getInt(1));
                studentGroup.setNameGroup(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentGroup;
    }

    @Override
    public void deleteGroup(StudentGroup studentGroup) {
        StudentDao studentDao = new StudentDaoImpl();
        GradeDao gradeDao = new GradeDaoImpl();

        try {
            String URL = "Delete from student_group where id = " + studentGroup.getId() + ";";
            PreparedStatement preparedStatement = connectDB.returnConnection().prepareStatement(URL);
            int count = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

