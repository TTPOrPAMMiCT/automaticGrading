package dao.studentGroupDao;

import com.mysql.cj.jdbc.result.ResultSetInternalMethods;
import dao.gradeDao.GradeDao;
import dao.gradeDao.GradeDaoImpl;
import dao.studentDao.StudentDao;
import dao.studentDao.StudentDaoImpl;
import entity.view.StudentGroupView;
import utility.dataBase.ConnectDB;
import entity.model.StudentGroup;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentGroupDaoImpl extends StudentGroupDao{
    ConnectDB connectDB = new ConnectDB();
    Statement statement;

    public StudentGroupDaoImpl() {
        try {
            statement = connectDB
                    .returnConnection()
                    .createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List findGroup() {
        List groupList = new ArrayList();
        try {
            String QUERY = "select * from student_group";
            ResultSet resultSet = statement.executeQuery(QUERY);

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
    public List findGroupView() {
        List groupList = new ArrayList();
        try {
            String QUERY = "select * from student_group";
            ResultSet resultSet = statement.executeQuery(QUERY);

            while (resultSet.next()) {
                groupList.add(new StudentGroupView(new StudentGroup(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                )));
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
            String QUERY = "select * from student_group where id = '" + id + "'";
            ResultSet resultSet = statement.executeQuery(QUERY);

            if (resultSet.next()) {
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
        try {
            String QUERY = "DELETE from student_group WHERE id = " + studentGroup.getId() + ";";
            PreparedStatement preparedStatement = connectDB.returnConnection().prepareStatement(QUERY);
            int count = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void createGroup(StudentGroup studentGroup) {
        String QUERY = "INSERT INTO student_group(name_group) VALUES ('" + studentGroup.getNameGroup() + "');";
        try {
            PreparedStatement preparedStatement = connectDB.returnConnection().prepareStatement(QUERY);
            int count = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

