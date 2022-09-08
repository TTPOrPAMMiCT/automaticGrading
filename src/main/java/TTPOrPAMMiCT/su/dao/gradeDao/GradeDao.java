package TTPOrPAMMiCT.su.dao.gradeDao;

import TTPOrPAMMiCT.su.entity.model.Student;
import java.util.List;

interface GradeDao {
    List findGrade(int idStudent);
    void editGrade(Student student, List<Integer> gradeList);
    void deleteFullGrades(int idStudent);
}
