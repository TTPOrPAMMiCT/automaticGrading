package TTPOrPAMMiCT.su.service.view.studentView;

import TTPOrPAMMiCT.su.service.student.StudentServiceImpl;
import TTPOrPAMMiCT.su.utility.converter.Convert;
import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.model.Student;
import TTPOrPAMMiCT.su.entity.view.StudentView;
import TTPOrPAMMiCT.su.service.student.StudentService;
import TTPOrPAMMiCT.su.utility.converter.student.StudentConverter;
import TTPOrPAMMiCT.su.utility.converter.studentView.StudentViewConverter;

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
        Convert<StudentView, Student> convert = new StudentConverter();
        studentDao.deleteEntity(convert.convert(studentView));
    }

    @Override
    public void updateStudent(StudentView studentView) {
        StudentConverter studentConverter = new StudentConverter();
        Student student = studentConverter.convert(studentView);
        studentDao.updateStudent(student);
    }

    @Override
    public List<StudentView> getEntityListBySquad(Squad squad) {
        List<Student> studentList = studentDao.getEntityListBySquad(squad);
        List<StudentView> studentViewList = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            studentViewList.add(studentViewConverter.convert(studentList.get(i)));
        }
        return studentViewList;
    }
}
