package service.dao;

import dao.studentDao.StudentDao;
import dao.studentDao.StudentDaoImpl;
import entity.model.Student;
import entity.model.StudentGroup;
import org.hibernate.Session;
import utility.dataBase.HibernateUtil;

import java.util.List;

public class StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    public List<Student> findAll() {
        Session session = HibernateUtil.openSession();
        List<Student> students = studentDao.findAll(session);
        HibernateUtil.closeSession(session);
        return students;
    }

    public List<Student> findByGroup(StudentGroup studentGroup) {
        Session session = HibernateUtil.openSession();
        List<Student> students = studentDao.findByGroup(session, studentGroup);
        HibernateUtil.closeSession(session);
        return students;
    }

    public void addStudent(Student student) {
        Session session = HibernateUtil.openSessionWithTransaction();
        studentDao.addStudent(session, student);
        HibernateUtil.closeSessionWithTransaction(session);
    }

}
