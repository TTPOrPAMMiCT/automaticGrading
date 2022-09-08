package TTPOrPAMMiCT.su.dao.SquadDao;

import TTPOrPAMMiCT.su.entity.model.Squad;
import org.hibernate.Session;

import java.util.List;

interface SquadDao {
    List<Squad> getListSquad(Session session);
    Squad getSquadById(Session session, int id);
    void deleteSquad(Session session, Squad squad);
    void createSquad(Session session, Squad squad);
}
