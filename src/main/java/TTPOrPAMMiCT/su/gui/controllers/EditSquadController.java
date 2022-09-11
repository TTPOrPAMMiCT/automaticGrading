package TTPOrPAMMiCT.su.gui.controllers;

import TTPOrPAMMiCT.su.dao.Dao;
import TTPOrPAMMiCT.su.dao.SquadDao;
import TTPOrPAMMiCT.su.dao.StudentDao;
import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.model.Student;
import TTPOrPAMMiCT.su.service.DaoService;
import TTPOrPAMMiCT.su.service.SquadService;
import TTPOrPAMMiCT.su.service.StudentService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class EditSquadController extends FxController{
    public TableColumn delete;
    public TableColumn surname;

    public TableColumn name;
    public TableColumn middleName;
    public TableColumn squad;
    public Button addStudent;
    public TextField txtSurname;
    public TextField txtMiddleName;
    public TextField txtName;
    public TextField nameSquad;
    public Button addSquad;

    DaoService<Student> studentDaoService = new StudentService();
    DaoService<Squad> squadDaoService = new SquadService();

    @Override
    void initialize() {
    }

    public void clickAddStudent(ActionEvent actionEvent) {

    }

    public void clickAddSquad(ActionEvent actionEvent) {
        Squad squad1 = new Squad();
        squad1.setName(nameSquad.getText());
        squadDaoService.saveEntity(squad1);
    }
}
