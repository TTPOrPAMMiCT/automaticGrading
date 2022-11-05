package TTPOrPAMMiCT.su.utility.converter.squadView;

import TTPOrPAMMiCT.su.utility.converter.Convert;
import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.view.SquadView;

public class SquadViewConverter implements Convert<Squad, SquadView> {
    @Override
    public SquadView convert(Squad o) {
        SquadView squadView = new SquadView();
        squadView.setId(o.getId());
        squadView.setName(o.getName());
        squadView.setStudents(o.getStudents());
        return squadView;
    }
}
