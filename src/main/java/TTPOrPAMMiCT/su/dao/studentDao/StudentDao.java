package TTPOrPAMMiCT.su.dao.studentDao;

import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.model.Student;
import TTPOrPAMMiCT.su.entity.view.StudentView;

import java.util.List;

interface StudentDao {
    List<StudentView> findStudents();
    List<StudentView> findStudentsFromId(Squad squad);
    void deleteStudent(int idStudent);
    void deleteStudentFromGroup(Squad squad);
    void updateStudent(StudentView studentView);
    void addStudent(Student student);

}
