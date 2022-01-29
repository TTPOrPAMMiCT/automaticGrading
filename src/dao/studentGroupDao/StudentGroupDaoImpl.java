package dao.studentGroupDao;

import utility.dataBase.ConnectDB;
import entity.model.StudentGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentGroupDaoImpl extends StudentGroupDao{
    ConnectDB connectDB = new ConnectDB();

    @Override
    public List findGroup() {
        List groupList = new ArrayList();
        try {
            String url = "select * from studentGroup";
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
}
