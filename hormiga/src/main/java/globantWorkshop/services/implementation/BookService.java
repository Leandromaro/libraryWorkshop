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
        List<Book> books = bookDao.getAllBooks();
        return (ArrayList<Book>) books;
    }

    @Override
    public Book create(Book book) throws PersistenceException {
        if(bookDao.getById(book.getIsbn())!=null || !Book.validateIsbn(book.getIsbn())) return null;
        bookDao.create(book);
        return bookDao.getById(book.getIsbn());
    }

    @Override
    public String delete(int id) {
        try{
            Book book = bookDao.getById(id);
            bookDao.delete(book);
        } catch (Exception ex){
            return "Error deleting book: " + ex.toString();
        }
        return "Book deleted successfully";
    }

    @Override
    public String updateBook(Book newBook){
        try {
            Book book = bookDao.getById(newBook.getIsbn());
            book.setName(newBook.getName());
            book.setAuthor(newBook.getAuthor());
            book.setIsbn(newBook.getIsbn());
            bookDao.update(book);
        } catch (Exception ex){
            return "Error updating book: " + ex.toString();
        }

        return "Book updated successfully";
    }

    @Override
    public Book findBookById(int bookId) throws TransactionSystemException {
        return bookDao.getById(bookId);
    }

}
