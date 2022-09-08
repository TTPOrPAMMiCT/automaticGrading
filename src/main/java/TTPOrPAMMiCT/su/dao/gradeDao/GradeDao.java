package TTPOrPAMMiCT.su.dao.gradeDao;

import TTPOrPAMMiCT.su.entity.model.Student;

import java.util.List;

public abstract class GradeDao {
    public abstract List findGrade(int idStudent);
    public abstract void editGrade(Student student, List<Integer> gradeList);
    public abstract void deleteFullGrades(int idStudent);
}
