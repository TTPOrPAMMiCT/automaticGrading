package controllers;

import dao.gradeDao.GradeDaoImpl;
import dao.studentGroupDao.StudentGroupDao;
import dao.studentGroupDao.StudentGroupDaoImpl;
import entity.model.Grade;
import entity.model.StudentGroup;
import entity.view.StudentView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.initializeTable.InitializeStudent;
import service.searchInString.SearchInString;

import java.io.IOException;
import java.util.List;

public class MainWindow extends ConfigsControllers {
    @FXML
    public ComboBox<StudentGroup> choiceGroup;
    @FXML
    private Text nameGroup;
    @FXML
    private TableView<StudentView> table;
    @FXML
    private TableColumn<StudentView, Integer> idLine;
    @FXML
    private TableColumn<StudentView, String> surname;
    @FXML
    private TableColumn<StudentView, String> name;
    @FXML
    private TableColumn<StudentView, String> middleName;
    @FXML
    public TableColumn<StudentView, String> grades;
    @FXML
    private TableColumn<StudentView, Integer> averageScore;
    @FXML
    private Button listGroup;

    private InitializeStudent init = new InitializeStudent();
    ObservableList<StudentView> studentViews;
    private int id;

    @Override
    public void createWindow(ActionEvent actionEvent)  {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.setTitle("_MainWindow_");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    private void initialize() {
        initListStudents();
        initChoiceGroup();
        editTable();
        initTable();
    }

    private void initListStudents() {
        studentViews = FXCollections.observableList(init.initializeStudentView());
    }

    public void initTable() {

        idLine.setCellValueFactory(new PropertyValueFactory<>("idLine"));

        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));

        middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));

        grades.setCellValueFactory(new PropertyValueFactory<>("gradesString"));

        averageScore.setCellValueFactory(new PropertyValueFactory<>("averageScore"));

        table.setItems(studentViews);
    }

    public void editTable() {
       grades.setCellFactory(TextFieldTableCell.forTableColumn());
        grades.setOnEditCommit(event -> {
            StudentView student = event
                    .getTableView()
                    .getItems()
                    .get(event.getTablePosition().getRow());

            editGrade(
                    event.getNewValue(),
                    student
            );
        });

        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(event -> {
             event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue());
        });


        surname.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(event -> {});

        middleName.setCellFactory(TextFieldTableCell.forTableColumn());
        middleName.setOnEditCommit(event -> {});
    }

    public List<Grade> editGrade(String newGradeList, StudentView student) {
        SearchInString search = new SearchInString();
        GradeDaoImpl gradeDao = new GradeDaoImpl();
        List<Integer> newGrade = search.getListSymbolsAndParseInt(newGradeList);
        if (student.getGradeList().size() != newGrade.size()) {

        }
        return null;
    }

    public void initChoiceGroup() {
        StudentGroupDao dao = new StudentGroupDaoImpl();
        ObservableList<StudentGroup> groups = FXCollections.observableList(dao.findGroup());
        choiceGroup.setItems(groups);
        choiceGroup.setOnAction(actionEvent -> {
            nameGroup.setText(choiceGroup.getValue().getNameGroup());
        });
    }


    public void editListStudent(ActionEvent actionEvent) {
        System.out.println(studentViews.get(0));
    }
        /*EditListStudent editListStudent = new EditListStudent();
        editListStudent.setStudentViews(studentViews);
        try {
            editListStudent.createWindow(new ActionEvent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
