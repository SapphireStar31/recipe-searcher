package persistence;

import entity.Recipes;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import java.util.List;

public class RecipesDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get author by id.
     */
    public Recipes getById(int id) {
        Session session = sessionFactory.openSession();
        Recipes recipes = session.get(Recipes.class, id);
        session.close();
        return recipes;
    }

    /**
     * Update author.
     *
     * @param recipes author to be updated
     */
    public void update(Recipes recipes) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(recipes);
        transaction.commit();
        session.close();
    }

    /**
     * Insert a new author.
     * @param recipes author to be inserted
     */
    public int insert(Recipes recipes) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(recipes);
        transaction.commit();
        id = recipes.getRecipeNameID();
        session.close();
        return id;
    }

    /**
     * Delete an author.
     * @param recipes author to be deleted
     */
    public void delete(Recipes recipes) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(recipes);
        transaction.commit();
        session.close();
    }


    /**
     * Return a list of all authors.
     * @return All authors
     */
    public List<Recipes> getAll() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Recipes> query = builder.createQuery(Recipes.class);
        Root<Recipes> root = query.from(Recipes.class);
        List<Recipes> recipes = session.createSelectionQuery( query ).getResultList();

        logger.debug("The list of authors " + recipes);
        session.close();

        return recipes;
    }
}
