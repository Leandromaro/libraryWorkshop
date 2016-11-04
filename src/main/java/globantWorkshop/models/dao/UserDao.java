package globantWorkshop.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import globantWorkshop.models.entities.User;
import org.springframework.stereotype.Repository;

/**
 * This class is used to access data for the User entity.
 * Repository annotation allows the component scanning support to find and 
 * configure the DAO wihtout any XML configuration and also provide the Spring 
 * exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class UserDao {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  // An EntityManager will be automatically injected from entityManagerFactory
  // setup on DatabaseConfig class.

  @PersistenceContext
  private EntityManager entityManager;

  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  public void create(User user) {
    entityManager.persist(user);
    return;
  }

  public void delete(User user) {
    if (entityManager.contains(user))
      entityManager.remove(user);
    else
      entityManager.remove(entityManager.merge(user));
    return;
  }

  @SuppressWarnings("unchecked")
  public List<User> getAllUsers() {
    return entityManager.createQuery("from User").getResultList();
  }

  public List<User> getByEmail(String email) {
    return entityManager.createQuery(
            "from User where email = :email")
            .setParameter("email", email)
            .getResultList();
  }


  public User getById(int id) {
    return entityManager.find(User.class, id);
  }

  public void update(User user) {
    entityManager.merge(user);
    return;
  }
}
