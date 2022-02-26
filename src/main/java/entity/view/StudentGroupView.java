package entity.view;

import dao.studentGroupDao.StudentGroupDao;
import dao.studentGroupDao.StudentGroupDaoImpl;
import entity.model.StudentGroup;

import java.awt.*;

public class StudentGroupView extends StudentGroup {
    Button delete = new Button("удалит");

    public StudentGroupView(StudentGroup studentGroup) {
        setId(studentGroup.getId());
        setNameGroup(studentGroup.getNameGroup());
    }

    //////////////////////////////////////////button action

    public void clickDelete() {
        getDelete().addActionListener(e -> {
            StudentGroupDao studentGroupDao = new StudentGroupDaoImpl();
            studentGroupDao.deleteGroup(this);
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
