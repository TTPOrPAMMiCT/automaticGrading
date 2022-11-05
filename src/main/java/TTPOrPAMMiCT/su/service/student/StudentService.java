package TTPOrPAMMiCT.su.service.student;

import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.model.Student;
import TTPOrPAMMiCT.su.service.DaoService;

import java.util.List;

public interface StudentService extends DaoService<Student> {
    void updateStudent(Student student);

    List<Student> getEntityListBySquad(Squad squad);
}
