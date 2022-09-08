package TTPOrPAMMiCT.su.dao.studentDao;

import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.model.Student;
import TTPOrPAMMiCT.su.entity.view.StudentView;

import java.util.List;

public abstract class StudentDao {
    public abstract List<StudentView> findStudents();
    public abstract List<StudentView> findStudentsFromId(Squad squad);
    public abstract void deleteStudent(int idStudent);
    public abstract void deleteStudentFromGroup(Squad squad);
    public abstract void updateStudent(StudentView studentView);
    public abstract void addStudent(Student student);

}
