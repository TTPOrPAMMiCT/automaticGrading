package TTPOrPAMMiCT.su.dao.squad;

import TTPOrPAMMiCT.su.dao.Dao;
import TTPOrPAMMiCT.su.entity.model.Squad;
import org.hibernate.Session;

public interface SquadDao extends Dao<Squad> {
    void update(Squad squad, Session session);
}
