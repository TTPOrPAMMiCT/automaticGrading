package dao.studentDao;

import entity.model.Student;
import entity.model.StudentGroup;
import org.hibernate.Session;

import java.util.List;

public abstract class StudentDao {
    public abstract List<Student> findAll(Session session);
    public abstract List<Student> findByGroup(Session session, StudentGroup studentGroup);
    public abstract void addStudent(Session session, Student student);
    public abstract void deleteStudent(Session session, Student student);
}
