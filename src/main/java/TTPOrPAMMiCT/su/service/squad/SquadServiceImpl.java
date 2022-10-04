package TTPOrPAMMiCT.su.service.squad;

import TTPOrPAMMiCT.su.dao.squad.SquadDao;
import TTPOrPAMMiCT.su.dao.squad.SquadDaoImpl;
import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.utility.database.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class SquadServiceImpl implements SquadService{
    SquadDao dao = new SquadDaoImpl();

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
