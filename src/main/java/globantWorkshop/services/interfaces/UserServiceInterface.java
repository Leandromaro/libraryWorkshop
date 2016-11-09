package globantWorkshop.services.interfaces;

import globantWorkshop.models.entities.User;
import org.springframework.transaction.TransactionSystemException;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandromaro on 24/10/16.
 */
public interface UserServiceInterface {

    /**
     * Method created to get all the added users
     * @return ArrayList<User>
     */
    public ArrayList<User> getAllUsers();

    /**
     * Create a new user with an auto-generated id and email and name as passed
     * values.
     */
    public User create(User user) throws PersistenceException;

    /**
     * Delete the user with the passed id.
     */

    public String delete(int idUser);

    /**
     * Update the email and the name for the user indentified by the passed id.
     */
    public String updateUserValues(User userParam) throws TransactionSystemException;

    /**
     * Retrieve a user from the id passed as parameter.
     */
    public User findUserById(int userId) throws TransactionSystemException;
}
