package TTPOrPAMMiCT.su.gui.controllers;

import TTPOrPAMMiCT.su.service.view.studentView.StudentViewService;
import TTPOrPAMMiCT.su.service.view.studentView.StudentViewServiceImpl;
import TTPOrPAMMiCT.su.utility.converter.string.StringConverter;
import TTPOrPAMMiCT.su.utility.converter.student.StudentConverter;
import TTPOrPAMMiCT.su.entity.model.Grade;
import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.view.StudentView;
import TTPOrPAMMiCT.su.service.grade.GradeService;
import TTPOrPAMMiCT.su.service.grade.GradeServiceImpl;
import TTPOrPAMMiCT.su.service.squad.SquadService;
import TTPOrPAMMiCT.su.service.squad.SquadServiceImpl;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainWindowController extends FxController {

    public Button editSquad;
    public ChoiceBox<Squad> boxSquad;
    public TableView<StudentView> studentTable;
    public Button updateTable;
    @FXML
    private TableColumn<StudentView, String> surname;
    @FXML
    private TableColumn<StudentView, String> name;
    @FXML
    private TableColumn<StudentView, String> middleName;
    @FXML
    private TableColumn<StudentView, String> grade;
    @FXML
    private TableColumn<StudentView, Double> averageGrade;
    @FXML
    private TableColumn<StudentView, Integer> finalGrade;
    private EditSquadController editSquadController = new EditSquadController();

    @Override
    void initialize() {
        setCellFactory();
        setValueChoiceBox();
        setValueStudentTable();
        setProperties();
        editTableColumns();
    }

    private void editTableColumns() {

        name.setOnEditCommit(event -> {
            StudentView student = event.getTableView().getItems().get(event.getTablePosition().getRow());
            student.setName(event.getNewValue());
            StudentViewService studentViewService = new StudentViewServiceImpl();
            studentViewService.updateStudent(student);
        });

        surname.setOnEditCommit(event -> {
            StudentView student = event.getTableView().getItems().get(event.getTablePosition().getRow());
            student.setSurname(event.getNewValue());
            StudentViewService studentViewService = new StudentViewServiceImpl();
            studentViewService.updateStudent(student);
        });

        middleName.setOnEditCommit(event -> {
            StudentView student = event.getTableView().getItems().get(event.getTablePosition().getRow());
            student.setMiddleName(event.getNewValue());
            StudentViewService studentViewService = new StudentViewServiceImpl();
            studentViewService.updateStudent(student);
        });

        grade.setOnEditCommit(event -> {
            StudentView student = event.getTableView().getItems().get(event.getTablePosition().getRow());

            try {
                List<Grade> gradeListDelete = student.getGradeList();
                GradeService gradeService = new GradeServiceImpl();
                for (int i = 0; i < gradeListDelete.size(); i++) {
                    gradeService.deleteEntity(gradeListDelete.get(i));
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            StringConverter stringConverter = new StringConverter();
            List<Integer> gradeListInteger = stringConverter.getListSymbolsAndParseInt(event.getNewValue());

            List<Grade> gradeList = new ArrayList<>();
            StudentConverter studentConverter = new StudentConverter();

            for (int i = 0; i < gradeListInteger.size(); i++) {
                Grade grade1 = new Grade();
                grade1.setGrade(gradeListInteger.get(i));
                grade1.setStudent(studentConverter.convert(student));
                gradeList.add(grade1);
            }

            student.setGradeList(gradeList);

            System.out.println(student);

            studentTable.refresh();


            StudentViewService studentViewService = new StudentViewServiceImpl();
            studentViewService.updateStudent(student);
        });
    }

    private void setProperties() {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        grade.setCellValueFactory(new PropertyValueFactory<>("gradeString"));
        averageGrade.setCellValueFactory(new PropertyValueFactory<>("averageGrade"));
        finalGrade.setCellValueFactory(new PropertyValueFactory<>("finalGrade"));
    }

    private void setValueStudentTable() {
        StudentViewService studentViewService = new StudentViewServiceImpl();
        boxSquad.setOnAction(actionEvent -> {
            try {
                studentTable.setItems(FXCollections.observableList(studentViewService.getEntityListBySquad(boxSquad.getValue())));
                studentTable.refresh();
            } catch (Exception e) {
                studentTable.setItems(FXCollections.observableList(studentViewService.getEntityList()));
            }
        });
    }


    private void setValueChoiceBox() {
        SquadService service = new SquadServiceImpl();
        boxSquad.setItems(FXCollections.observableList(service.getEntityList()));
    }

    private void setCellFactory() {
        surname.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        middleName.setCellFactory(TextFieldTableCell.forTableColumn());
        grade.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void clickEditSquad(ActionEvent actionEvent) {
        if (!editSquadController.isAliveWindow()) {
            editSquadController.createWindow(new ActionEvent(), "editSquad.fxml", "Редактор групп");
        }
    }

    public void clickUpdateTable(ActionEvent actionEvent) {
        SquadService service = new SquadServiceImpl();
        boxSquad.setItems(FXCollections.observableList(service.getEntityList()));
        StudentViewService studentViewService = new StudentViewServiceImpl();
        try {
            studentTable.setItems(FXCollections.observableList(studentViewService.getEntityListBySquad(boxSquad.getValue())));
            studentTable.refresh();
        } catch (Exception e) {
            studentTable.setItems(FXCollections.observableList(studentViewService.getEntityList()));
        }
    }

    @Override
    public void createWindow(ActionEvent actionEvent, String nameFile, String nameWindow) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load((getClass().getResource(("/windows/fxml/" + nameFile))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setScene(new Scene(parent));
        getStage().setScene(getScene());
        getStage().setTitle(nameWindow);
        getStage().show();
        setAliveWindow(true);
        getStage().setOnCloseRequest(event -> {
            setAliveWindow(false);
            System.exit(0);
        });
    }


}
