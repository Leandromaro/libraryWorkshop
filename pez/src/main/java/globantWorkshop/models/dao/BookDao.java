package globantWorkshop.models.dao;

import globantWorkshop.models.entities.Book;
import globantWorkshop.models.entities.User;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 *
 * @author leandromaro
 */
@Repository
@Transactional
public class BookDao {

@PersistenceContext
private EntityManager entityManager;


    public void create(Book book) {
    	entityManager.persist(book);
        return;
    }

    public void delete(Book book) {
    	if (entityManager.contains(book))
	      entityManager.remove(book);
	    else
	      entityManager.remove(entityManager.merge(book));
	    return;
    }

    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks(){
    	return entityManager.createQuery("from Book").getResultList();
    }

    public Book getById(int id) {
        return entityManager.find(Book.class, id);
      }

	  public void update(Book book) throws Exception{
	    entityManager.merge(book);
	    return;
	  }

}
     





    
