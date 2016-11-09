package globantWorkshop.models.dao;

import globantWorkshop.models.entities.Book;

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
        //Should Be implemented
        return;
    }

    public void delete(Book book) {
        //Should Be implemented
            return;
    }

    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks(){
        //Should Be implemented
        List bookList = new ArrayList<>();
        return bookList;
    }

    public void update(Book book) throws Exception{
        //Should Be implemented
        return;
    }

    public Book getById(int id) {
    //Should Be implemented
        return new Book();
    }

}
     





    
