package TTPOrPAMMiCT.su.utility.converter.student;

import TTPOrPAMMiCT.su.utility.converter.Convert;
import TTPOrPAMMiCT.su.entity.model.Student;
import TTPOrPAMMiCT.su.entity.view.StudentView;

public class StudentConverter implements Convert<StudentView, Student> {
    @Override
    public Student convert(StudentView o) {
        Student student = new Student();
        student.setId(o.getId());
        student.setName(o.getName());
        student.setMiddleName(o.getMiddleName());
        student.setSurname(o.getSurname());
        student.setSquad(o.getSquad());
        student.setGradeList(o.getGradeList());
        return student;
    }
}
