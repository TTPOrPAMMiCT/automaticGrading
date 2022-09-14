package TTPOrPAMMiCT.su.service.view.studentView;

import TTPOrPAMMiCT.su.entity.model.Student;
import TTPOrPAMMiCT.su.entity.view.StudentView;
import TTPOrPAMMiCT.su.service.student.StudentService;
import TTPOrPAMMiCT.su.service.student.StudentServiceImpl;
import TTPOrPAMMiCT.su.utility.converter.student.StudentConverter;
import TTPOrPAMMiCT.su.utility.converter.studentView.StudentViewConverter;
import TTPOrPAMMiCT.su.utility.database.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class StudentViewServiceImpl implements StudentViewService {
    StudentService studentDao = new StudentServiceImpl();
    StudentViewConverter studentViewConverter = new StudentViewConverter();

    @Override
    public void saveEntity(StudentView studentView) {
        studentDao.saveEntity(studentView);
    }

    @Override
    public List<StudentView> getEntityList() {
        List<Student> studentList = studentDao.getEntityList();
        List<StudentView> studentViewList = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            studentViewList.add(studentViewConverter.convert(studentList.get(i)));
        }
        return studentViewList;
    }

    @Override
    public List<StudentView> getEntityListById(int id) {
        List<Student> studentList = studentDao.getEntityListById(id);
        List<StudentView> studentViewList = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            studentViewList.add(studentViewConverter.convert(studentList.get(i)));
        }
        return studentViewList;
    }

    @Override
    public void deleteEntity(StudentView studentView) {
        studentDao.deleteEntity(studentView);
    }

    @Override
    public void updateStudent(StudentView studentView) {
        StudentConverter studentConverter = new StudentConverter();
        Student student = studentConverter.convert(studentView);
        Session session = HibernateUtil.openSessionWithTransaction();
        studentDao.updateStudent(student);
        HibernateUtil.closeSessionWithTransaction(session);
    }
}
