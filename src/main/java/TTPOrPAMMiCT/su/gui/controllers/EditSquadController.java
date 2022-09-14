package TTPOrPAMMiCT.su.gui.controllers;

import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.model.Student;
import TTPOrPAMMiCT.su.entity.view.SquadView;
import TTPOrPAMMiCT.su.entity.view.StudentView;
import TTPOrPAMMiCT.su.service.DaoService;
import TTPOrPAMMiCT.su.service.squad.SquadServiceImpl;
import TTPOrPAMMiCT.su.service.student.StudentServiceImpl;
import TTPOrPAMMiCT.su.service.view.SquadView.SquadViewServiceImpl;
import TTPOrPAMMiCT.su.service.view.studentView.StudentViewService;
import TTPOrPAMMiCT.su.service.view.studentView.StudentViewServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditSquadController extends FxController{

    ////////////////////////////////table
    @FXML
    public TableView<SquadView> tblSquadByTabSquad;
    @FXML
    public TableColumn<SquadView, Button> tblSquadDelete;
    @FXML
    public TableColumn<SquadView, String> tblNameGroup;
    @FXML
    private volatile TableView<StudentView> studentTable;
    @FXML
    private TableColumn<StudentView, Button> tblStudeDelete;
    @FXML
    private TableColumn<StudentView, String> tblSurname;
    @FXML
    private TableColumn<StudentView, String> tblName;
    @FXML
    private TableColumn<StudentView, String> tblMiddleName;
    @FXML
    private TableColumn<StudentView, Squad> tblSquad;
    ////////////////////////////////table
    ////////////////////////////////text field
    @FXML
    private TextField txtSurname;
    @FXML
    private TextField txtMiddleName;
    @FXML
    private TextField txtName;
    @FXML
    public TextField txtNameSquad;
    ////////////////////////////////text field
    ////////////////////////////////button
    @FXML
    private Button addStudent;
    @FXML
    private Button addSquad;
    ////////////////////////////////button
    ////////////////////////////////choice box
    @FXML
    private ChoiceBox<Squad> squadBox;
    ////////////////////////////////choice box


    @Override
    void initialize() {
        setCellFactory();
        setProperties();
        setItemsInSquadBox();
        setItemsInSquadTable();
        setItemsInStudentTable();
        editTableColumns();
    }

    private void setItemsInSquadTable() {
        SquadViewServiceImpl squadViewService = new SquadViewServiceImpl();
        Thread setItems = new Thread(() -> {
            tblSquadByTabSquad.setItems(FXCollections.observableList(squadViewService.getEntityList()));
        });
        setItems.start();
    }

    private void editTableColumns() {

        tblName.setOnEditCommit(event -> {
            StudentView student = event.getTableView().getItems().get(event.getTablePosition().getRow());
            student.setName(event.getNewValue());
            new Thread(new UpdateStudent(student)).start();
        });

        tblSurname.setOnEditCommit(event -> {
            StudentView student = event.getTableView().getItems().get(event.getTablePosition().getRow());
            student.setSurname(event.getNewValue());
            new Thread(new UpdateStudent(student)).start();
        });

        tblSquad.setOnEditCommit(event -> {
            //todo create edit squad by student
        });

        tblMiddleName.setOnEditCommit(event -> {
            StudentView student = event.getTableView().getItems().get(event.getTablePosition().getRow());
            student.setMiddleName(event.getNewValue());
            new Thread(new UpdateStudent(student)).start();
        });


        tblSquadDelete.setOnEditCommit(event -> {

        });

    }

    private synchronized void setItemsInStudentTable() {
        DaoService<StudentView> studentViewDaoService = new StudentViewServiceImpl();
        Thread setItemsStudentTable = new Thread(() ->
                studentTable.setItems(FXCollections.observableList(studentViewDaoService.getEntityList()))
        );
        setItemsStudentTable.start();
    }

    private void setItemsInSquadBox() {
        DaoService<Squad> squadDaoService = new SquadServiceImpl();
        Thread setItemsInSquadBox = new Thread(() -> {
            squadBox.setItems(FXCollections.observableList(squadDaoService.getEntityList()));
        }
        );
        setItemsInSquadBox.start();
    }

    private void setProperties() {
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        tblMiddleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        tblSquad.setCellValueFactory(new PropertyValueFactory<>("squad"));
        tblStudeDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));


        tblSquadDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        tblNameGroup.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    private void setCellFactory() {
        tblSurname.setCellFactory(TextFieldTableCell.forTableColumn());
        tblName.setCellFactory(TextFieldTableCell.forTableColumn());
        tblMiddleName.setCellFactory(TextFieldTableCell.forTableColumn());
        /*squad.setCellFactory(ChoiceBoxTableCell.forTableColumn());*/

        tblNameGroup.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    @FXML
    public void clickAddStudent(ActionEvent actionEvent) {
        if (!txtName.getText().isEmpty() && !txtSurname.getText().isEmpty() && !txtMiddleName.getText().isEmpty() && squadBox.getValue() != null) {
            Student student = new Student();
            student.setName(txtName.getText());
            student.setSurname(txtSurname.getText());
            student.setMiddleName(txtMiddleName.getText());
            student.setSquad(squadBox.getValue());

            Object sync = new Object();
            Thread saveStudent = new Thread(() -> {
                DaoService<Student> studentDaoService = new StudentServiceImpl();
                studentDaoService.saveEntity(student);
                txtName.clear();
                txtSurname.clear();
                txtMiddleName.clear();
                synchronized (sync) {
                    sync.notify();
                }
            });


            Thread updateStudentTable = new Thread(() -> {
                synchronized (sync) {
                    try {
                        sync.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                DaoService<StudentView> studentViewDaoService = new StudentViewServiceImpl();
                studentViewDaoService.getEntityList();

                ObservableList<StudentView> studentViewObservableList = FXCollections.observableList(studentViewDaoService.getEntityList());
                studentTable.setItems(studentViewObservableList);
                studentTable.refresh();
            });
            saveStudent.start();
            updateStudentTable.start();
        }
    }

    public void clickAddSquad(ActionEvent actionEvent) {
        DaoService<Squad> squadDaoService = new SquadServiceImpl();
        SquadViewServiceImpl squadViewService = new SquadViewServiceImpl();
        Object sync = new Object();

        if (!txtNameSquad.getText().isEmpty()) {
            Squad squad1 = new Squad();
            squad1.setName(txtNameSquad.getText());
            txtNameSquad.clear();

            Thread saveSquad = new Thread(() -> {
                squadDaoService.saveEntity(squad1);
                synchronized (sync) {
                    sync.notify();
                }
            });
            saveSquad.start();

            Thread updateItems = new Thread(() -> {
                synchronized (sync) {
                    try {
                        sync.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                squadDaoService.getEntityList();
                getSquadBox().setItems(FXCollections.observableList(squadDaoService.getEntityList()));
                squadViewService.getEntityList();
                tblSquadByTabSquad.setItems(FXCollections.observableList(squadViewService.getEntityList()));
                tblSquadByTabSquad.refresh();
            });
            updateItems.start();

        }
    }

    class UpdateStudent implements Runnable {
        StudentView studentView;

        public UpdateStudent (StudentView studentView) {
            this.studentView = studentView;
        }
        @Override
        public void run() {
            StudentViewService studentViewService = new StudentViewServiceImpl();
            studentViewService.updateStudent(studentView);
        }
    }
}
