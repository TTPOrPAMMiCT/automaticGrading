package dao.studentDao;


import entity.model.Student;
import entity.model.StudentGroup;
import org.hibernate.Session;
import service.dao.StudentService;

import java.util.List;

public class StudentDaoImpl extends StudentDao {

    @Override
    public List<Student> findAll(Session session) {
        return (List<Student>) session.createSQLQuery("select * from student").addEntity(Student.class).list();
    }

    @Override
    public List<Student> findByGroup(Session session, StudentGroup studentGroup) {
        return (List<Student>) session.createSQLQuery("select * from student where group_id = " + studentGroup.getId())
                .addEntity(Student.class)
                .list();
    }

    @Override
    public void addStudent(Session session, Student student) {
        session.save(student);
    }

    public void deleteStudent(Session session, Student student) {
        session.delete(student);
    }

    public static void main(String[] args) {
        StudentService student = new StudentService();

    }
}
