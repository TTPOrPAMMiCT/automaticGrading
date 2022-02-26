package dao.studentDao;

import entity.model.Grade;
import entity.model.Student;
import entity.model.StudentGroup;
import entity.view.StudentView;

import java.util.List;

public abstract class StudentDao {
    public abstract List<StudentView> findStudents();
    public abstract List<StudentView> findStudentsFromId(StudentGroup studentGroup);
    public abstract void deleteStudent(int idStudent);
    public abstract void deleteStudentFromGroup(StudentGroup studentGroup);
    public abstract void updateStudent(StudentView studentView);
    public abstract void addStudent(Student student);

}
