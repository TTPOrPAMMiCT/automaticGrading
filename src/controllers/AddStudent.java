package controllers;

import com.sun.javafx.collections.ObservableListWrapper;
import dao.studentGroupDao.StudentGroupDaoImpl;
import entity.model.Student;
import entity.model.StudentGroup;
import entity.view.StudentView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AddStudent extends ConfigsControllers {

    @FXML
    private TextField surname;

    @FXML
    private TextField middleName;

    @FXML
    private TextField name;

    @FXML
    private ChoiceBox<StudentGroup> choiceGroup;

    @FXML
    private Button add;

    @FXML
    private Button exit;

    @FXML
    private TableView<StudentView> table;

    @FXML
    private TableColumn<StudentView, Button> choice;

    @FXML
    private TableColumn<StudentView, String> surnameTable;

    @FXML
    private TableColumn<StudentView, String> nameTable;

    @FXML
    private TableColumn<StudentView, String> middleNameTable;

    @FXML
    private TableColumn<StudentView, String> group;

    private List<StudentView> studentViews = new ArrayList<>();

    @FXML
    private void initialize() {
        initTable();
        initGroup();
    }

    private void initGroup() {
        StudentGroupDaoImpl studentGroupDao = new StudentGroupDaoImpl();
        ObservableList<StudentGroup> studentGroups = FXCollections.observableList(studentGroupDao.findGroup());
        choiceGroup.setItems(studentGroups);
    }

    private void initTable() {
        ObservableList<StudentView> studentViewObservableList = FXCollections.observableList(studentViews);
        table.setItems(studentViewObservableList);
        choice.setCellValueFactory(new PropertyValueFactory<>("deleteStudent"));
        surnameTable.setCellValueFactory(new PropertyValueFactory<>("surname"));
        nameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        middleNameTable.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        group.setCellValueFactory(new PropertyValueFactory<>(""));
    }

    @FXML
    void clickAdd(ActionEvent event) {
        StudentView studentView = new StudentView();
        studentView.setName(name.getText());
        studentView.setSurname(surname.getText());
        studentView.setMiddleName(middleName.getText());
        studentView.setIdGroup(choiceGroup.getValue().getId());
        studentView.setStudentGroup(choiceGroup.getValue());
        studentViews.add(studentView);
        table.refresh();
    }

    @Override
    public void createWindow(ActionEvent actionEvent)  {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/addStudent.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.setTitle("_addStudent_");
        stage.centerOnScreen();
        stage.show();
    }

    public void clickExit(ActionEvent actionEvent) {

    }
}
