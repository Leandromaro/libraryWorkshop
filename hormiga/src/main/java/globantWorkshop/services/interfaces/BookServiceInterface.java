package globantWorkshop.services.interfaces;

import globantWorkshop.models.entities.Book;
import org.springframework.transaction.TransactionSystemException;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandromaro on 29/10/16.
 */
public interface BookServiceInterface {
    /**
     * Method created to get all the added books
     * @return ArrayList<User>
     */
    public List<Book> getAllBooks();

    /**
     * Create a new book with an auto-generated id and author, name
     * and number of copies passed values.
     */
    public Book create(Book book) throws PersistenceException;

    /**
     * Delete the book with the passed id.
     */

    public String delete(int id);

    /**
     * Update the book atributes
     */
    public String updateBook(Book bookParam) throws TransactionSystemException;

    /**
     * Retrieve a book from the id passed as parameter.
     */
    public Book findBookById(int bookId) throws TransactionSystemException;

    /**
     * created by Augusto
     * Retrieve a book from the isbn passed as parameter.
     */
    public boolean findBookByIsbn(int bookIsbn) throws TransactionSystemException;

}

