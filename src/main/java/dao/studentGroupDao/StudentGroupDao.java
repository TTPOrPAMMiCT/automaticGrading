package dao.studentGroupDao;

import entity.model.StudentGroup;
import org.hibernate.Session;

import java.util.List;

public abstract class StudentGroupDao {
    public abstract List<StudentGroup> findAll(Session session);
    public abstract void deleteGroup(Session session, StudentGroup studentGroup);
    public abstract void createGroup(Session session, StudentGroup studentGroup);
}
