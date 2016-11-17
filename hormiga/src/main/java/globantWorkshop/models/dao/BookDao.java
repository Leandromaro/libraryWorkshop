package globantWorkshop.models.dao;

import globantWorkshop.models.entities.Book;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import globantWorkshop.models.entities.User;
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


    public void create(Book book) throws PersistenceException {
        entityManager.persist(book);
        return;
    }

    public void delete(Book book) {
        if(entityManager.contains(book)) entityManager.remove(book);
        else entityManager.remove(entityManager.merge(book));
    }

    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks(){
        return entityManager.createQuery("from Book").getResultList();
    }

    public void update(Book book) throws Exception{
        entityManager.merge(book);
        return;
    }

    public Book getById(Integer id) {
        return entityManager.find(Book.class,id);
    }

}
     





    
