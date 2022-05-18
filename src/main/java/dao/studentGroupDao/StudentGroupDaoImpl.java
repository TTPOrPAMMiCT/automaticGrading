package dao.studentGroupDao;

import entity.model.StudentGroup;
import org.hibernate.Session;

import java.util.List;

public class StudentGroupDaoImpl extends StudentGroupDao{

    @Override
    public List<StudentGroup> findAll(Session session) {
        return (List<StudentGroup>) session.createSQLQuery("select * from student_group").addEntity(StudentGroup.class).list();
    }

    @Override
    public void deleteGroup(Session session, StudentGroup studentGroup) {
        session.delete(studentGroup);
    }

    @Override
    public void createGroup(Session session, StudentGroup studentGroup) {
        session.save(studentGroup);
    }
}

