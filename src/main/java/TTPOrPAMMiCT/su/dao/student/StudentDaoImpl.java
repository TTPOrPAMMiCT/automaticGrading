package TTPOrPAMMiCT.su.dao.student;

import TTPOrPAMMiCT.su.dao.Dao;
import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.model.Student;
import org.hibernate.Session;
import java.util.List;

public class StudentDaoImpl implements StudentDao {


    @Override
    public synchronized void saveEntity(Student student, Session session) {
        session.save(student);
    }

    @Override
    public synchronized List<Student> getEntityList(Session session) {
        return (List<Student>) session.createSQLQuery("select * from student").addEntity(Student.class).list();
    }

    @Override
    public List<Student> getEntityListById(int id, Session session) {
        return session.createSQLQuery("select * from student where id = " + id).addEntity(Student.class).list();
    }

    @Override
    public void deleteEntity(Student student, Session session) {
        session.delete(student);
    }

    @Override
    public List<Student> getEntityBySquad(Squad squad, Session session) {
        return session.createSQLQuery("select * from student where squad_id = " + squad.getId()).addEntity(Student.class).list();
    }

    @Override
    public void updateStudent(Student student, Session session) {
        session.update(student);
    }
}
