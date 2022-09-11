package TTPOrPAMMiCT.su.service;

import TTPOrPAMMiCT.su.dao.Dao;
import TTPOrPAMMiCT.su.dao.SquadDao;
import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.utility.database.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class SquadService implements DaoService<Squad> {
    Dao<Squad> dao = new SquadDao();

    @Override
    public void saveEntity(Squad squad) {
        Session session = HibernateUtil.openSessionWithTransaction();
        dao.saveEntity(squad, session);
        HibernateUtil.closeSessionWithTransaction(session);
    }

    @Override
    public List<Squad> getEntityList() {
        Session session = HibernateUtil.openSession();
        List squadList = dao.getEntityList(session);
        HibernateUtil.closeSession(session);
        return squadList;
    }

    @Override
    public List<Squad> getEntityListById(int id) {
        Session session = HibernateUtil.openSession();
        List squadList = dao.getEntityListById(id, session);
        HibernateUtil.closeSession(session);
        return squadList;
    }

    @Override
    public void deleteEntity(Squad squad) {
        Session session = HibernateUtil.openSessionWithTransaction();
        dao.deleteEntity(squad, session);
        HibernateUtil.closeSessionWithTransaction(session);
    }
}
