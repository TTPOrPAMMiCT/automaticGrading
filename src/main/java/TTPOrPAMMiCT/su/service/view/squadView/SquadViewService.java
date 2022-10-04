package TTPOrPAMMiCT.su.service.view.squadView;

import TTPOrPAMMiCT.su.entity.view.SquadView;
import TTPOrPAMMiCT.su.service.DaoService;

interface SquadViewService extends DaoService<SquadView> {
    void update(SquadView squadView);
}
