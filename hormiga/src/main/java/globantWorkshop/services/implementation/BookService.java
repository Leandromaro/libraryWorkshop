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
    public List<Book> getAllBooks() {
        List<Book> books = bookDao.getAllBooks();
        return books;
    }

    @Override
    public Book create(Book book) throws PersistenceException {
        if (findBookByIsbn(book.getIsbn()) || book.getIsbn()>=1000){
            return null;
        }else{
            bookDao.create(book);
            return bookDao.getById(book.getIdbooks());
        }
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
            bookDao.update(newBook);
            return "Book updated successfully";
        } catch (Exception ex){
            return "Error updating book: " + ex.toString();
        }
    }

    @Override
    public Book findBookById(int bookId) throws TransactionSystemException {
        return bookDao.getById(bookId);
    }

    /*Otra Forma de Buscar el libro por isbn*/

    @Override
    public boolean findBookByIsbn(int isbn){
        for (Book book:
             bookDao.getAllBooks()) {
            if (book.getIsbn().equals(isbn)) return true;
        }
        return false;
    }

}
