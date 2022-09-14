package TTPOrPAMMiCT.su.utility.database;

import TTPOrPAMMiCT.su.entity.model.Grade;
import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    static {
        //////////////config
        Configuration configuration = new Configuration().configure();
        configuration

                //mapping
                .addAnnotatedClass(Squad.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Grade.class);
                //mapping

        ////////////////////

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    public static Session openSessionWithTransaction() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        return session;
    }

    public static void closeSessionWithTransaction(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    public static Session openSession() {
        Session session = sessionFactory.openSession();

        return session;
    }

    public static void closeSession(Session session) {
        session.close();
    }
}
