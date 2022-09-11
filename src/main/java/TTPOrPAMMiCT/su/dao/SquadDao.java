package TTPOrPAMMiCT.su.dao;

import TTPOrPAMMiCT.su.entity.model.Squad;
import org.hibernate.Session;

import java.util.List;

public class SquadDao implements Dao<Squad> {

    @Override
    public void saveEntity(Squad squad, Session session) {

    }

    @Override
    public List<Squad> getEntityList(Session session) {
        return null;
    }

    @Override
    public List<Squad> getEntityListById(int id, Session session) {
        return null;
    }

    @Override
    public void deleteEntity(Squad squad, Session session) {

    }
}

