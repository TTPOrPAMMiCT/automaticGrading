package TTPOrPAMMiCT.su.dao.squad;

import TTPOrPAMMiCT.su.entity.model.Squad;
import org.hibernate.Session;

import java.util.List;

public class SquadDaoImpl implements SquadDao {

    @Override
    public void saveEntity(Squad squad, Session session) {
        session.save(squad);
    }

    @Override
    public List<Squad> getEntityList(Session session) {
        return (List<Squad>) session.createSQLQuery("select * from squad").addEntity(Squad.class).list();
    }

    @Override
    public List<Squad> getEntityListById(int id, Session session) {
        return session.createSQLQuery("select * squad where id = " + id).list();
    }

    @Override
    public void deleteEntity(Squad squad, Session session) {
        session.delete(squad);
    }

    @Override
    public void update(Squad squad, Session session) {
        session.update(squad);
    }
}

