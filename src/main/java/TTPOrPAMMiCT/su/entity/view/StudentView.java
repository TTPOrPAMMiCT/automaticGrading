package TTPOrPAMMiCT.su.entity.view;

import TTPOrPAMMiCT.su.entity.model.Student;
import javafx.scene.control.Button;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentView extends Student {
    private Button delete = new Button("удалить");

    @Override
    public String toString() {
        return "" + getId();
    }
}
