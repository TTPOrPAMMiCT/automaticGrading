package service.dao;

import dao.studentGroupDao.StudentGroupDao;
import dao.studentGroupDao.StudentGroupDaoImpl;
import entity.model.StudentGroup;
import org.hibernate.Session;
import utility.dataBase.HibernateUtil;

import java.util.List;

public class StudentGroupService {
    StudentGroupDao studentGroupDao = new StudentGroupDaoImpl();
    public List<StudentGroup> findAll() {
        Session session = HibernateUtil.openSession();
        List<StudentGroup> studentGroups = studentGroupDao.findAll(session);
        HibernateUtil.closeSession(session);
        return studentGroups;
    }

    public void create(StudentGroup studentGroup ) {
        Session session = HibernateUtil.openSessionWithTransaction();
        studentGroupDao.createGroup(session, studentGroup);
        HibernateUtil.closeSessionWithTransaction(session);
    }

    public void delete(StudentGroup studentGroup) {
        Session session = HibernateUtil.openSessionWithTransaction();
        studentGroupDao.deleteGroup(session, studentGroup);
        HibernateUtil.closeSessionWithTransaction(session);
    }
}
