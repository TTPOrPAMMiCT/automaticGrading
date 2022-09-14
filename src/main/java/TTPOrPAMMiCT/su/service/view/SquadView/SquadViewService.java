package TTPOrPAMMiCT.su.service.view.SquadView;

import TTPOrPAMMiCT.su.entity.view.SquadView;
import TTPOrPAMMiCT.su.service.DaoService;

interface SquadViewService extends DaoService<SquadView> {
    void update(SquadView squadView);
}
