package controllers;

import dao.studentDao.StudentDao;
import dao.studentDao.StudentDaoImpl;
import dao.studentGroupDao.StudentGroupDaoImpl;
import entity.model.Student;
import entity.model.StudentGroup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddStudentController extends Controller {

    @FXML
    private TextField txtSurname;

    @FXML
    private TextField txtMiddleName;

    @FXML
    private TextField txtName;

    @FXML
    private ChoiceBox<StudentGroup> choiceGroup;

    @FXML
    private Button add;

    private Stage stage = new Stage();
    Button delete = new Button();

    @FXML
    private void initialize() {
        initGroup();
    }

    private void initGroup() {
        StudentGroupDaoImpl studentGroupDao = new StudentGroupDaoImpl();
        ObservableList<StudentGroup> studentGroups = FXCollections.observableList(studentGroupDao.findGroup());
        choiceGroup.setItems(studentGroups);
    }


    @FXML
    void clickAdd(ActionEvent event) {
        StudentDao studentDao = new StudentDaoImpl();
        if (checkTextTextField()) {
            studentDao.addStudent(new Student(
                    txtName.getText(),
                    txtSurname.getText(),
                    txtMiddleName.getText(),
                    choiceGroup.getValue().getId()
            ));
            System.out.println("create student");
        } else {
            System.out.println("not create");
        }

        Controller.getMainWindowController().updateTableContent();
        Controller.getMainWindowController().getEditListStudentController().updateTableContent();
    }

    private Boolean checkTextTextField() {
        if (!txtName.getText().isEmpty() && !txtSurname.getText().isEmpty() && !txtMiddleName.getText().isEmpty() && choiceGroup.getValue() != null ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void createWindow(ActionEvent actionEvent)  {
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
}
