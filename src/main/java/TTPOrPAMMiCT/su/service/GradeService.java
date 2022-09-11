package TTPOrPAMMiCT.su.service;

import TTPOrPAMMiCT.su.dao.Dao;
import TTPOrPAMMiCT.su.dao.GradeDao;
import TTPOrPAMMiCT.su.entity.model.Grade;
import TTPOrPAMMiCT.su.utility.database.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class GradeService implements DaoService<Grade>{
    Dao<Grade> dao = new GradeDao();


    @Override
    public void saveEntity(Grade grade) {
        Session session = HibernateUtil.openSessionWithTransaction();
        dao.saveEntity(grade, session);
        HibernateUtil.closeSessionWithTransaction(session);
    }

    @Override
    public List<Grade> getEntityList() {
        Session session = HibernateUtil.openSession();
        List gradeList = dao.getEntityList(session);
        HibernateUtil.closeSession(session);
        return gradeList;
    }

    @Override
    public List<Grade> getEntityListById(int id) {
        Session session = HibernateUtil.openSessionWithTransaction();
        List gradeList = dao.getEntityListById(id, session);
        HibernateUtil.closeSession(session);
        return gradeList;
    }

    @Override
    public void deleteEntity(Grade grade) {
        Session session = HibernateUtil.openSessionWithTransaction();
        dao.deleteEntity(grade, session);
        HibernateUtil.closeSessionWithTransaction(session);
    }


}
