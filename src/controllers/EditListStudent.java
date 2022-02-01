package controllers;

import entity.model.StudentGroup;
import entity.view.StudentView;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class EditListStudent extends  ConfigsControllers {

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
    private TableColumn<StudentView, String> group;

    @FXML
    private Button addStudent;

    @FXML
    private Button exit;

    @FXML
    private ChoiceBox<StudentGroup> choiceGroup;

    @FXML
    private Button addGroup;

    private ObservableList<StudentView> studentViews;


    @FXML
    private void initialize() {

    }

    @FXML
    void clickAddGroup(ActionEvent event) {

    }

    @FXML
    void clickAddStudent(ActionEvent event) {
        AddStudent addStudent = new AddStudent();
        addStudent.createWindow(new ActionEvent());
    }

    @FXML
    void exit(ActionEvent event) {

    }

    private void initTable() {
        table.setItems(studentViews);

        choice.setCellValueFactory(new PropertyValueFactory<>(""));

        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));

        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));

    }


    ////////////////////////////////////get set /////////////////////////////////

    public ObservableList<StudentView> getStudentViews() {
        return studentViews;
    }

    public void setStudentViews(ObservableList<StudentView> studentViews) {
        this.studentViews = studentViews;
    }

    /////////////////////////////////////window settings///////////////////////////


    @Override
    public void createWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/editListStudent.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.setTitle("_MainWindow_");
        stage.centerOnScreen();
        stage.show();
    }
}
