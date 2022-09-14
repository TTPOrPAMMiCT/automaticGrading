package TTPOrPAMMiCT.su.entity.view;

import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.service.view.SquadView.SquadViewServiceImpl;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SquadView extends Squad {
    private Button delete = new Button("удалить");

    public SquadView() {
        delete.setOnAction(event -> {
            SquadViewServiceImpl squadViewService = new SquadViewServiceImpl();
            squadViewService.deleteEntity(SquadView.this);

        });
    }

}
