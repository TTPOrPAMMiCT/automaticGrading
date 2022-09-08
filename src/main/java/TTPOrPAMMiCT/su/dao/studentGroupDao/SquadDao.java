package TTPOrPAMMiCT.su.dao.studentGroupDao;

import TTPOrPAMMiCT.su.entity.model.Squad;
import org.hibernate.Session;

import java.util.List;

public abstract class SquadDao {
    public abstract List<Squad> getListSquad(Session session);
    public abstract Squad getSquadById(Session session, int id);
    public abstract void deleteSquad(Session session, Squad squad);
    public abstract void createSquad(Session session, Squad squad);
}
