package TTPOrPAMMiCT.su.utility.convrter.studentView;

import TTPOrPAMMiCT.su.entity.model.Student;
import TTPOrPAMMiCT.su.entity.view.StudentView;
import TTPOrPAMMiCT.su.utility.convrter.Convert;

public class StudentViewConverter implements Convert<Student, StudentView> {

    @Override
    public StudentView convert(Student o) {
        StudentView studentView = new StudentView();
        studentView.setId(o.getId());
        studentView.setName(o.getName());
        studentView.setSurname(o.getSurname());
        studentView.setMiddleName(o.getMiddleName());
        studentView.setSquad(o.getSquad());
        studentView.setGradeList(o.getGradeList());
        return studentView;
    }
}
