package controllers;

import dao.gradeDao.GradeDaoImpl;
import dao.studentDao.StudentDaoImpl;
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
/*import javafx.scene.control.cell.TextFieldTableCell;*/
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.initializeTable.InitializeStudentView;
import service.searchInString.SearchInString;

import java.io.IOException;
import java.util.ArrayList;
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
    @FXML
    private Button addStudent;

    @Override
    public void createWindow(ActionEvent actionEvent) throws IOException {
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
        initChoiceGroup();
        editTable();
    }

    public void initTable(int id) {
        InitializeStudentView init = new InitializeStudentView();

        idLine.setCellValueFactory(new PropertyValueFactory<>("idLine"));

        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));

        middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));

        grades.setCellValueFactory(new PropertyValueFactory<>("gradesString"));

        averageScore.setCellValueFactory(new PropertyValueFactory<>("averageScore"));

        table.setItems(FXCollections.observableList(init.initializeStudentView(id)));
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
    }

    public void editGrade(String newGradeList, StudentView student) {
        InitializeStudentView init = new InitializeStudentView();
        SearchInString search = new SearchInString();
        GradeDaoImpl gradeDao = new GradeDaoImpl();
        List<Integer> newGrade = search.getListSymbolsAndParseInt(newGradeList);
        if (student.getGradeList().size() != newGrade.size()) {
            gradeDao.editGrade(student, newGrade);
            table.setItems(FXCollections.observableList(init.initializeStudentView(choiceGroup.getValue().getId())));
        }
    }

    public void initChoiceGroup() {
        StudentGroupDao dao = new StudentGroupDaoImpl();
        ObservableList<StudentGroup> groups = FXCollections.observableList(dao.findGroup());
        choiceGroup.setItems(groups);
        choiceGroup.setOnAction(actionEvent -> {
            nameGroup.setText(choiceGroup.getValue().getNameGroup());
            initTable(choiceGroup.getValue().getId());
        });
    }


}
