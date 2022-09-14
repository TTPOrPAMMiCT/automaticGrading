package TTPOrPAMMiCT.su.service.student;

import TTPOrPAMMiCT.su.entity.model.Student;
import TTPOrPAMMiCT.su.service.DaoService;
import org.hibernate.Session;

public interface StudentService extends DaoService<Student> {
    void updateStudent(Student student);
}
