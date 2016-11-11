package globantWorkshop.services.implementation;

import globantWorkshop.models.dao.BookDao;
import globantWorkshop.models.entities.Book;
import globantWorkshop.services.interfaces.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandromaro on 29/10/16.
 */
@Service
public class BookService implements BookServiceInterface {

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Autowired
    BookDao bookDao;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    @Override
    public ArrayList<Book> getAllBooks() {
        //Should Be implemented
        List<Book> books = new ArrayList<Book>();
        return (ArrayList<Book>) books;
    }

    @Override
    public Book create(Book book) throws PersistenceException {
        //Should Be implemented
        return new Book();
    }

    @Override
    public String delete(int id) {
        return "Should Be implemented\n";
    }

    @Override
    public String updateBook(Book newBook){
        return "Should Be implemented";
    }

    @Override
    public Book findBookById(int bookId) throws TransactionSystemException {
        Book book = new Book();
        //Should Be implemented
        return book;
    }

}
