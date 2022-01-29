package dao.gradeDao;

import entity.model.Student;

import java.util.List;

public abstract class GradeDao {
    public abstract List findGrade(int idStudent);
    public abstract void editGrade(Student student, List<Integer> gradeList);
}
