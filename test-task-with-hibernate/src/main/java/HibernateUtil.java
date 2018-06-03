import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Class to quickly get SessionFactory
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}