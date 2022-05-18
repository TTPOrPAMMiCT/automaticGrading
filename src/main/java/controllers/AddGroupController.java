package controllers;

import dao.studentGroupDao.StudentGroupDao;
import dao.studentGroupDao.StudentGroupDaoImpl;
import entity.view.StudentGroupView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class AddGroupController extends Controller{

    public TableView<StudentGroupView> table;

    public TableColumn<StudentGroupView, Button> choice;

    public TableColumn<StudentGroupView, String> group;

    public Button add;

    public TextField nameGroup;

    Stage stage = new Stage();

    @FXML
    private void initialize() {
        getMainWindowController().setAddGroupController(this);
        updateTable();
        initTable();
    }

    public void initTable() {
        choice.setCellValueFactory(new PropertyValueFactory<>("delete"));

        group.setCellValueFactory(new PropertyValueFactory<>("nameGroup"));
    }

    public void updateTable() {
        StudentGroupDao studentGroupDao = new StudentGroupDaoImpl();


    }

    public void clickAdd(ActionEvent actionEvent) {
        StudentGroupDao studentGroupDao = new StudentGroupDaoImpl();
        if(nameGroup.getText() != "") {
            nameGroup.clear();
            Controller.getMainWindowController().updateChoiceGroup();
            Controller.getMainWindowController().getEditListStudentController().updateChoiceGroup();
            updateTable();
        }
    }

    ///////////////////////////////////////winndow setting


    @Override
    public void createWindow(ActionEvent actionEvent) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/addGroup.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.setTitle("_список групп_");
        stage.centerOnScreen();
        stage.show();
    }
}
