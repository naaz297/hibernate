import jakarta.persistence.EntityManager;

public class JPADemoMain {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            UserClassHibernate user =
                    new UserClassHibernate(null, "naaz");

            em.persist(user);

            em.getTransaction().commit();

            System.out.println("User saved successfully!");

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            e.printStackTrace();

        } finally {

            em.close();
            JPAUtil.close();
        }
    }
}