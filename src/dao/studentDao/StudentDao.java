package dao.studentDao;

import entity.model.Grade;
import entity.model.Student;
import entity.model.StudentGroup;
import entity.view.StudentView;

import java.util.List;

public abstract class StudentDao {
    public abstract List<Student> findStudents(int idGroup);
}
