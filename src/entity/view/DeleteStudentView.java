package entity.view;

import entity.model.Student;

import javafx.scene.control.Button;


public class DeleteStudentView extends Student {
    private Button checkStudent = new Button();

    public DeleteStudentView() {
    }

    public DeleteStudentView(Student student) {
        setId(student.getId());
        setName(student.getName());
        setSurname(student.getSurname());
        setMiddleName(student.getMiddleName());
        setIdGroup(student.getIdGroup());
        setDefaultButton();
    }

    public void setDefaultButton() {
        checkStudent.setText("удалить");
    }

    public Button getCheckStudent() {
        return checkStudent;
    }

    public void setCheckStudent(Button checkStudent) {
        this.checkStudent = checkStudent;
    }

    @Override
    public String toString() {
        return "DeleteStudentView{" +
                "checkStudent=" + checkStudent +
                '}';
    }
}
