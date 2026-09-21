import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateDemoMain {

    public static void main(String[] args) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            UserClassHibernate user =
                    new UserClassHibernate(null, "naaz");

            session.persist(user);

            transaction.commit();

            System.out.println("User saved successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }
    }
}