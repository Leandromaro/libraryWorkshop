package globantWorkshop.services.implementation;

import globantWorkshop.models.dao.BookDao;
import globantWorkshop.models.dao.CopiesDao;
import globantWorkshop.models.entities.Book;
import globantWorkshop.services.interfaces.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

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

    @Autowired
    CopiesDao copiesDao;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    @Override
    public ArrayList<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
        try {
            books = bookDao.getAllBooks();
        } catch (Exception ex) {
            throw ex;
        }
        return (ArrayList<Book>) books;
    }


    @Override
    public String create(String name, String author, int ISBN) {
        try {
            Book newBook = new Book();
            newBook.setName(name);
            newBook.setAuthor(author);
            newBook.setIsbn(ISBN);
            bookDao.create(newBook);
        }catch (Exception ex) {
            return "Error creating the book: " + ex.toString();
        }
        return "Book succesfully created!";
    }

    @Override
    public String delete(int id) {
        try {
            Book book = bookDao.getById(id);
            bookDao.delete(book);
        }catch (Exception ex) {
            return "Error deleting the book: " + ex.toString();
        }
        return "Book succesfully deleted!";
    }

    @Override
    public String updateName(String name, String author, int ISBN) throws TransactionSystemException {
        return null;
    }

}
