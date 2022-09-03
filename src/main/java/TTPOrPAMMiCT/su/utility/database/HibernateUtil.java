package TTPOrPAMMiCT.su.utility.database;

import TTPOrPAMMiCT.su.entity.model.Grade;
import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    static {
        //////////////config
        Configuration configuration = new Configuration().configure();
        configuration

                //mapping
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Squad.class)
                .addAnnotatedClass(Grade.class);
                //mapping

        ////////////////////

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    public static Session openSession() {
        Session session = getSessionFactory().openSession();
        return session;
    }

    public static Session openSessionWithTransaction() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        return session;
    }

    public static void closeSessionWithTransaction(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    public static void closeSession(Session session) {
        session.close();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
