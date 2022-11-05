package TTPOrPAMMiCT.su.service.grade;

import TTPOrPAMMiCT.su.dao.grade.GradeDao;
import TTPOrPAMMiCT.su.dao.grade.GradeDaoImpl;
import TTPOrPAMMiCT.su.entity.model.Grade;
import TTPOrPAMMiCT.su.utility.database.HibernateUtil;
import org.hibernate.Session;


import java.util.List;

public class GradeServiceImpl implements GradeService {
    GradeDao dao = new GradeDaoImpl();

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

    @Override
    public void saveEntity(Grade grade) {
        Session session = HibernateUtil.openSessionWithTransaction();
        dao.saveEntity(grade, session);
        HibernateUtil.closeSessionWithTransaction(session);
    }
}
