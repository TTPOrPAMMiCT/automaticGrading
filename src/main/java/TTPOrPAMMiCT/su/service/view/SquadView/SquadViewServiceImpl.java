package TTPOrPAMMiCT.su.service.view.SquadView;

import TTPOrPAMMiCT.su.dao.squad.SquadDao;
import TTPOrPAMMiCT.su.dao.squad.SquadDaoImpl;
import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.view.SquadView;
import TTPOrPAMMiCT.su.utility.converter.squad.SquadConverter;
import TTPOrPAMMiCT.su.utility.converter.squadView.SquadViewConverter;
import TTPOrPAMMiCT.su.utility.database.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

//todo
public class SquadViewServiceImpl implements SquadViewService {
    SquadDao squadDao = new SquadDaoImpl();
    SquadConverter squadConverter = new SquadConverter();
    SquadViewConverter squadViewConverter = new SquadViewConverter();

    @Override
    public void saveEntity(SquadView squadView) {

    }

    @Override
    public List<SquadView> getEntityList() {
        Session session = HibernateUtil.openSession();
        List<Squad> squadList = squadDao.getEntityList(session);
        HibernateUtil.closeSession(session);
        List<SquadView> squadViewList = new ArrayList<>();
        for (int i = 0; i < squadList.size(); i++) {
            squadViewList.add(squadViewConverter.convert(squadList.get(i)));
        }
        return squadViewList;
    }

    @Override
    public List<SquadView> getEntityListById(int id) {
        return null;
    }

    @Override
    public void deleteEntity(SquadView squadView) {
        Session session = HibernateUtil.openSessionWithTransaction();
        squadDao.deleteEntity(squadConverter.convert(squadView), session);
        HibernateUtil.closeSessionWithTransaction(session);
    }

    @Override
    public void update(SquadView squadView) {
        Session session = HibernateUtil.openSessionWithTransaction();
        squadDao.update(squadConverter.convert(squadView), session);
        HibernateUtil.closeSessionWithTransaction(session);
    }
}
