package TTPOrPAMMiCT.su.entity.view;

import TTPOrPAMMiCT.su.entity.model.Student;
import javafx.scene.control.CheckBox;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentView extends Student {
    private CheckBox delete = new CheckBox("удалить");

    @Override
    public String toString() {
        return "" + getId();
    }
}
