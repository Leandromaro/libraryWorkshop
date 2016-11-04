package globantWorkshop.services.interfaces;

import globantWorkshop.models.entities.Book;
import globantWorkshop.models.entities.User;
import org.springframework.transaction.TransactionSystemException;

import java.util.ArrayList;

/**
 * Created by leandromaro on 29/10/16.
 */
public interface BookServiceInterface {
    /**
     * Method created to get all the added books
     * @return ArrayList<User>
     */
    public ArrayList<Book> getAllBooks();

    /**
     * Create a new book with an auto-generated id and author, name
     * and number of copies passed values.
     */
    public String create(String name, String author, int ISBN);

    /**
     * Delete the book with the passed id.
     */

    public String delete(int id);

    /**
     * Update the book atributes
     */
    public String updateName(String name, String author, int ISBN) throws TransactionSystemException;

}

