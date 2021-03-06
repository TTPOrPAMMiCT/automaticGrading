package controllers;

import dao.gradeDao.GradeDaoImpl;
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
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import service.search.Search;

import java.io.IOException;
import java.util.List;

public class MainWindowController extends Controller {
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
    private ObservableList<StudentView> studentViews;
    private EditListStudentController editListStudentController = new EditListStudentController();
    private AddGroupController addGroupController;
    private Stage stage;

    @Override
    public void createWindow(ActionEvent actionEvent)  {
        stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.setTitle("_главное окно_");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    private void initialize() {
        updateChoiceGroup();
        editTable();
        initTable();
        updateTableContent();
        setMainWindowController(this);
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

    public void initTable() {
        idLine.setCellValueFactory(new PropertyValueFactory<>("idLine"));

        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));

        middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));

        grades.setCellValueFactory(new PropertyValueFactory<>("gradesString"));

        averageScore.setCellValueFactory(new PropertyValueFactory<>("averageScore"));
    }

    public void editTable() {
        StudentDao studentDao = new StudentDaoImpl();

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
            StudentView studentView = event
                    .getTableView()
                    .getItems()
                    .get(event.getTablePosition().getRow());
            studentView.setName(event.getNewValue());
            studentDao.updateStudent(studentView);
        });

        surname.setCellFactory(TextFieldTableCell.forTableColumn());
        surname.setOnEditCommit(event -> {
            StudentView studentView = event
                    .getTableView()
                    .getItems()
                    .get(event.getTablePosition().getRow());
            studentView.setSurname(event.getNewValue());
            studentDao.updateStudent(studentView);
        });

        middleName.setCellFactory(TextFieldTableCell.forTableColumn());
        middleName.setOnEditCommit(event -> {
            StudentView studentView = event
                    .getTableView()
                    .getItems()
                    .get(event.getTablePosition().getRow());
            studentView.setMiddleName(event.getNewValue());
            studentDao.updateStudent(studentView);
        });
    }

    public void editGrade(String newGradeList, StudentView student) {
        Search search = new Search();
        GradeDaoImpl gradeDao = new GradeDaoImpl();
        List<Integer> newGrade = search.getListSymbolsAndParseInt(newGradeList);
        if (student.getGradeList().size() != newGrade.size()) {
            gradeDao.editGrade(student, search.getListSymbolsAndParseInt(newGradeList));
        }
        updateTableContent();
    }

    public void updateChoiceGroup() {
        StudentGroupDao dao = new StudentGroupDaoImpl();
        StudentDao studentDao = new StudentDaoImpl();

        ObservableList<StudentGroup> groups = FXCollections.observableList(dao.findGroup());
//        groups.add(new StudentGroup("все группы"));
        choiceGroup.setPromptText("группы");
        choiceGroup.setItems(groups);
        choiceGroup.setOnAction(actionEvent -> {
            nameGroup.setText(choiceGroup.getValue().getNameGroup());
            studentViews.remove(0, studentViews.size());
            studentViews.addAll(studentDao.findStudentsFromId(choiceGroup.getValue()));
        });
    }


    public void clickEditListStudent(ActionEvent actionEvent) {
        try {
            editListStudentController.createWindow(new ActionEvent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////getters and setters


    public AddGroupController getAddGroupController() {
        return addGroupController;
    }

    public void setAddGroupController(AddGroupController addGroupController) {
        this.addGroupController = addGroupController;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public EditListStudentController getEditListStudentController() {
        return editListStudentController;
    }

    public void setEditListStudentController(EditListStudentController editListStudentController) {
        this.editListStudentController = editListStudentController;
    }

    public ComboBox<StudentGroup> getChoiceGroup() {
        return choiceGroup;
    }

    public void setChoiceGroup(ComboBox<StudentGroup> choiceGroup) {
        this.choiceGroup = choiceGroup;
    }

    public Text getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(Text nameGroup) {
        this.nameGroup = nameGroup;
    }

    public TableView<StudentView> getTable() {
        return table;
    }

    public void setTable(TableView<StudentView> table) {
        this.table = table;
    }

    public TableColumn<StudentView, Integer> getIdLine() {
        return idLine;
    }

    public void setIdLine(TableColumn<StudentView, Integer> idLine) {
        this.idLine = idLine;
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

    public TableColumn<StudentView, String> getGrades() {
        return grades;
    }

    public void setGrades(TableColumn<StudentView, String> grades) {
        this.grades = grades;
    }

    public TableColumn<StudentView, Integer> getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(TableColumn<StudentView, Integer> averageScore) {
        this.averageScore = averageScore;
    }

    public Button getListGroup() {
        return listGroup;
    }

    public void setListGroup(Button listGroup) {
        this.listGroup = listGroup;
    }

    public ObservableList<StudentView> getStudentViews() {
        return studentViews;
    }

    public void setStudentViews(ObservableList<StudentView> studentViews) {
        this.studentViews = studentViews;
    }
    ///////////////////////////////////////////////////////////////////////////
}
