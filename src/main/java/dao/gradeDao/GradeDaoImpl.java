package dao.gradeDao;

import entity.model.Student;
import utility.dataBase.ConnectDB;
import entity.model.Grade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl extends GradeDao{
    ConnectDB connectDB = new ConnectDB();

    @Override
    public List findGrade(int idStudent) {
        List gradeList = new ArrayList();
        try {
            String sql = "select * from grade where student_id = " + idStudent + ";";
            Statement statement = connectDB
                    .returnConnection()
                    .createStatement();

            ResultSet resultSet = statement
                    .executeQuery(sql);

            while (resultSet.next()) {
                gradeList.add(new Grade(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeList;
    }

    @Override
    public void editGrade(Student student, List<Integer> gradeList)  {
        try {
            deleteFullGrades(student.getId());

            PreparedStatement preparedStatement = connectDB
                    .returnConnection()
                    .prepareStatement("insert into grade(grade, student_id) values (?,?)");

            for (int i = 0; i < gradeList.size(); i++) {
                preparedStatement.setInt(1, gradeList.get(i));
                preparedStatement.setInt(2, student.getId());
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFullGrades(int idStudent) {
        Statement statement = null;
        try {
            statement = connectDB.returnConnection().createStatement();
            int countDelete = statement.executeUpdate("DELETE FROM grade WHERE student_id = " + idStudent + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
