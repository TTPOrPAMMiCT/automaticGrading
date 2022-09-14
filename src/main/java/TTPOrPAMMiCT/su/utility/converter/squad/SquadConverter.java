package TTPOrPAMMiCT.su.utility.converter.squad;

import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.view.SquadView;
import TTPOrPAMMiCT.su.utility.converter.Convert;

public class SquadConverter implements Convert<SquadView, Squad> {
    @Override
    public Squad convert(SquadView o) {
        Squad squad = new Squad();
        squad.setName(o.getName());
        squad.setId(o.getId());
        squad.setStudents(o.getStudents());
        return squad;
    }
}
