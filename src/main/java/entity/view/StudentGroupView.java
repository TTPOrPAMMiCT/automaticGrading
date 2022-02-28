package entity.view;

import controllers.Controller;
import dao.studentGroupDao.StudentGroupDao;
import dao.studentGroupDao.StudentGroupDaoImpl;
import entity.model.StudentGroup;
import javafx.scene.control.Button;


public class StudentGroupView extends StudentGroup {
    Button delete = new Button("удалить");

    public StudentGroupView(StudentGroup studentGroup) {
        setId(studentGroup.getId());
        setNameGroup(studentGroup.getNameGroup());
        clickDelete();
    }

    //////////////////////////////////////////button action

    public void clickDelete() {
        getDelete().setOnAction(e -> {
            StudentGroupDao studentGroupDao = new StudentGroupDaoImpl();
            studentGroupDao.deleteGroup(this);
            Controller.getMainWindowController().updateChoiceGroup();
            Controller.getMainWindowController().updateTableContent();
            Controller.getMainWindowController().getAddGroupController().updateTable();
            Controller.getMainWindowController().getEditListStudentController().updateChoiceGroup();
            Controller.getMainWindowController().getEditListStudentController().updateTableContent();
        });
    }

    //////////////////////////////////////////getters and setters

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }
}
