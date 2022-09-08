package TTPOrPAMMiCT.su.dao.SquadDao;


import TTPOrPAMMiCT.su.entity.model.Squad;
import org.hibernate.Session;

import java.util.List;

public class SquadDaoImpl implements SquadDao {


    @Override
    public List<Squad> getListSquad(Session session) {
        return session.createQuery("").list();
    }

    @Override
    public Squad getSquadById(Session session, int id) {
        return null;
    }

    @Override
    public void deleteSquad(Session session, Squad squad) {

    }

    @Override
    public void createSquad(Session session, Squad squad) {

    }
}

