package controllers;

import dao.studentDao.StudentDao;
import dao.studentDao.StudentDaoImpl;
import dao.studentGroupDao.StudentGroupDao;
import dao.studentGroupDao.StudentGroupDaoImpl;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class EditListStudentController extends Controller {

    @FXML
    private TableView<StudentView> table;

    @FXML
    private TableColumn<StudentView, Button> choice;

    @FXML
    private TableColumn<StudentView, String> surname;

    @FXML
    private TableColumn<StudentView, String> name;

    @FXML
    private TableColumn<StudentView, String> middleName;

    @FXML
    private TableColumn<StudentView, StudentGroup> group;

    @FXML
    private Button addStudent;

    @FXML
    private ComboBox<StudentGroup> choiceGroup;

    @FXML
    private Button addGroup;

    private ObservableList<StudentView> studentViews;
    private Stage stage;


    @FXML
    private void initialize() {
        initTable();
        updateChoiceGroup();
        updateTableContent();

        //this need to get access to te controller proxy object
        getMainWindowController().setEditListStudentController(this);
        System.out.println(choiceGroup.getValue());
    }

    public void updateTableContent() {
        StudentDao studentDao = new StudentDaoImpl();
        if (choiceGroup.getValue() != null) {
            studentViews = FXCollections.observableList(studentDao.findStudentsFromId(choiceGroup.getValue()));
        } else {
            studentViews = FXCollections.observableList(studentDao.findStudents());
        }
        table.setItems(studentViews);
    }



    private void initTable() {
        choice.setCellValueFactory(new PropertyValueFactory<>("deleteStudent"));

        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));

        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));

        group.setCellValueFactory(new PropertyValueFactory<>("studentGroup"));
    }

    private void updateChoiceGroup() {
        StudentGroupDao dao = new StudentGroupDaoImpl();
        StudentDao studentDao = new StudentDaoImpl();

        ObservableList<StudentGroup> groups = FXCollections.observableList(dao.findGroup());
//        groups.add(new StudentGroup("все группы"));
        choiceGroup.setPromptText("группы");
        choiceGroup.setItems(groups);
        choiceGroup.setOnAction(actionEvent -> {
            studentViews.remove(0, studentViews.size());
            studentViews.addAll(studentDao.findStudentsFromId(choiceGroup.getValue()));
        });
    }

    ////////////////////////////////////////////button
    @FXML
    void clickAddGroup(ActionEvent event) {

    }

    @FXML
    void clickAddStudent(ActionEvent event) {
        AddStudentController addStudentController = new AddStudentController();
        addStudentController.createWindow(new ActionEvent());
    }
    /////////////////////////////////////////////////

    /////////////////////////////////////window settings///////////////////////////


    @Override
    public void createWindow(ActionEvent actionEvent) throws IOException {
        stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/editListStudent.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.setTitle("_EditListStudent_");
        stage.centerOnScreen();
        stage.show();
    }

    //////////////////////////////////getters and setters

    public TableView<StudentView> getTable() {
        return table;
    }

    public void setTable(TableView<StudentView> table) {
        this.table = table;
    }

    public TableColumn<StudentView, Button> getChoice() {
        return choice;
    }

    public void setChoice(TableColumn<StudentView, Button> choice) {
        this.choice = choice;
    }

    public TableColumn<StudentView, String> getSurname() {
        return surname;
    }

    public void setSurname(TableColumn<StudentView, String> surname) {
        this.surname = surname;
    }

    public TableColumn<StudentView, String> getName() {
        return name;
    }

    public void setName(TableColumn<StudentView, String> name) {
        this.name = name;
    }

    public TableColumn<StudentView, String> getMiddleName() {
        return middleName;
    }

    public void setMiddleName(TableColumn<StudentView, String> middleName) {
        this.middleName = middleName;
    }

    public TableColumn<StudentView, StudentGroup> getGroup() {
        return group;
    }

    public void setGroup(TableColumn<StudentView, StudentGroup> group) {
        this.group = group;
    }

    public Button getAddStudent() {
        return addStudent;
    }

    public void setAddStudent(Button addStudent) {
        this.addStudent = addStudent;
    }

    public ComboBox<StudentGroup> getChoiceGroup() {
        return choiceGroup;
    }

    public void setChoiceGroup(ComboBox<StudentGroup> choiceGroup) {
        this.choiceGroup = choiceGroup;
    }

    public Button getAddGroup() {
        return addGroup;
    }

    public void setAddGroup(Button addGroup) {
        this.addGroup = addGroup;
    }

    public ObservableList<StudentView> getStudentViews() {
        return studentViews;
    }

    public void setStudentViews(ObservableList<StudentView> studentViews) {
        this.studentViews = studentViews;
    }


    ///////////////////////////////////////////////////
}
