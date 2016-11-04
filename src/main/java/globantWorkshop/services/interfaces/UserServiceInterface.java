package globantWorkshop.services.interfaces;

import globantWorkshop.models.entities.User;
import org.springframework.transaction.TransactionSystemException;

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
    public String create(String email, String name);

    /**
     * Delete the user with the passed id.
     */

    public String delete(int id);

    /**
     * Retrieve the id for the user with the passed email address.
     */

    public ArrayList<User> getByEmail(String email);

    /**
     * Update the email and the name for the user indentified by the passed id.
     */
    public String updateName(int id, String email, String name) throws TransactionSystemException;
}
