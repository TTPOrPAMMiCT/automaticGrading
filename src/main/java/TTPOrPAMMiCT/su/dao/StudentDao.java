package TTPOrPAMMiCT.su.dao;

import TTPOrPAMMiCT.su.entity.model.Student;
import org.hibernate.Session;
import java.util.List;

public class StudentDao implements Dao<Student> {


    @Override
    public void saveEntity(Student student, Session session) {

    }

    @Override
    public List<Student> getEntityList(Session session) {
        return null;
    }

    @Override
    public List<Student> getEntityListById(int id, Session session) {
        return null;
    }

    @Override
    public void deleteEntity(Student student, Session session) {

    }
}
