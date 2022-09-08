package TTPOrPAMMiCT.su.dao.studentDao;


import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.model.Student;
import TTPOrPAMMiCT.su.entity.view.StudentView;

import java.util.List;

public class StudentDaoImpl implements StudentDao {


    @Override
    public List<StudentView> findStudents() {
        return null;
    }

    @Override
    public List<StudentView> findStudentsFromId(Squad squad) {
        return null;
    }

    @Override
    public void deleteStudent(int idStudent) {

    }

    @Override
    public void deleteStudentFromGroup(Squad squad) {

    }

    @Override
    public void updateStudent(StudentView studentView) {

    }

    @Override
    public void addStudent(Student student) {

    }
}
