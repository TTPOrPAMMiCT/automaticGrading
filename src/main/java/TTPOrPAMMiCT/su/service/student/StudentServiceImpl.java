package TTPOrPAMMiCT.su.service.student;

import TTPOrPAMMiCT.su.dao.student.StudentDao;
import TTPOrPAMMiCT.su.dao.student.StudentDaoImpl;
import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.model.Student;
import TTPOrPAMMiCT.su.utility.database.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void saveEntity(Student o) {
        Session session = HibernateUtil.openSessionWithTransaction();
        studentDao.saveEntity(o, session);
        HibernateUtil.closeSessionWithTransaction(session);
    }

    @Override
    public List<Student> getEntityList() {
        Session session = HibernateUtil.openSession();
        List<Student> studentList = studentDao.getEntityList(session);
        HibernateUtil.closeSession(session);
        return studentList;
    }

    @Override
    public List<Student> getEntityListById(int id) {
        return null;
    }

    @Override
    public void deleteEntity(Student o) {
        Session session = HibernateUtil.openSessionWithTransaction();
        studentDao.deleteEntity(o, session);
        HibernateUtil.closeSessionWithTransaction(session);
    }

    @Override
    public void updateStudent(Student student) {
        Session session = HibernateUtil.openSessionWithTransaction();
        studentDao.updateStudent(student, session);
        HibernateUtil.closeSessionWithTransaction(session);
    }

    @Override
    public List<Student> getEntityListBySquad(Squad squad) {
        Session session = HibernateUtil.openSession();
        List<Student> studentList = studentDao.getEntityBySquad(squad, session);
        HibernateUtil.closeSession(session);
        return studentList;
    }
}
