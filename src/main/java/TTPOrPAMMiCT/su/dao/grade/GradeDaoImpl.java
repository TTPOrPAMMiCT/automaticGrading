package TTPOrPAMMiCT.su.dao.grade;

import TTPOrPAMMiCT.su.entity.model.Grade;
import org.hibernate.Session;

import java.util.List;

public class GradeDaoImpl implements GradeDao {

    @Override
    public void saveEntity(Grade grade, Session session) {
        session.save(grade);
    }

    @Override
    public List<Grade> getEntityList(Session session) {
        return (List<Grade>) session.createSQLQuery("from grade").addEntity(Grade.class).list();
    }

    @Override
    public List<Grade> getEntityListById(int id, Session session) {
        return (List<Grade>) session.createQuery("from grade where id =" + id ).list();
    }

    @Override
    public void deleteEntity(Grade grade, Session session) {
        session.delete(grade);
    }
}
