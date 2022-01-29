package controllers;

import dao.studentGroupDao.StudentGroupDao;
import dao.studentGroupDao.StudentGroupDaoImpl;
import entity.model.StudentGroup;
import entity.view.DeleteStudentView;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.initializeTable.InitializeStudent;
import java.io.IOException;

public class EditListStudent extends ConfigsControllers {

    @FXML
    private TableView<DeleteStudentView> table;

    @FXML
    private TableColumn<DeleteStudentView, Button> choice;

    @FXML
    private TableColumn<DeleteStudentView, String> surname;

    @FXML
    private TableColumn<DeleteStudentView, String> name;

    @FXML
    private TableColumn<DeleteStudentView, String> middleName;

    @FXML
    private Button exit;

    @FXML
    private ChoiceBox<StudentGroup> choiceGroup;

    private InitializeStudent initialize = new InitializeStudent();
    private ObservableList<DeleteStudentView> studentViews;

    @Override
    public void createWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/editListStudent.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.setTitle("_EditStudent_");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    private void initialize() {
        initChoiceGroup();
    }

    public void initTable(int idGroup) {
        studentViews = FXCollections.observableList(initialize.initializeDeleteStudentView(idGroup));
        table.setItems(studentViews);
        table.setEditable(true);

        choice.setCellValueFactory(new PropertyValueFactory<>("checkStudent"));

        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));

        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        System.out.println(studentViews);

    }

    public void initChoiceGroup() {
        StudentGroupDao dao = new StudentGroupDaoImpl();
        ObservableList<StudentGroup> groups = FXCollections.observableList(dao.findGroup());
        choiceGroup.setItems(groups);
        choice.setText("выбор группы");
        choiceGroup.setOnAction(actionEvent -> {
            initTable(choiceGroup.getValue().getId());
        });
    }

    @FXML
    void exit(ActionEvent event) {

    }


}
