package dao.view.studentViewDao;

import entity.view.StudentView;
import org.hibernate.Session;

import java.util.List;

public abstract class StudentViewDao {

    public abstract List<StudentView> findAll(Session session);
}
