package TTPOrPAMMiCT.su.dao.student;

import TTPOrPAMMiCT.su.dao.Dao;
import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.model.Student;
import org.hibernate.Session;

import java.util.List;

public interface StudentDao extends Dao<Student> {
    List<Student> getEntityBySquad(Squad squad, Session session);
    void updateStudent (Student student, Session session);
}
