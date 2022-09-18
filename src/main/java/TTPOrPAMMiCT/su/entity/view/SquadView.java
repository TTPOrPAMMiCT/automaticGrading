package TTPOrPAMMiCT.su.entity.view;

import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.service.view.SquadView.SquadViewServiceImpl;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SquadView extends Squad {
    private CheckBox delete = new CheckBox("удалить");

}
