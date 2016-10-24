package globantWorkshop.services.implementation;

import globantWorkshop.models.entities.User;
import globantWorkshop.models.dao.UserDao;
import globantWorkshop.services.interfaces.LibraryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandromaro on 23/10/16.
 */

@Service
public class LibraryService implements LibraryServiceInterface {

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Autowired
    UserDao userDao;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    @Override
    public ArrayList<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
        try {
            users = userDao.getAllUsers();
        } catch (Exception ex) {
            throw ex;
        }
        return (ArrayList<User>) users;
    }

    @Override
    public String create(String email, String name) {
        try {
            User user = new User(email, name);
            userDao.create(user);
        }
        catch (TransactionSystemException ex) {
            throw ex;
        }catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created!";
    }

    @Override
    public String delete(long id) {
        try {
            User user = new User(id);
            userDao.delete(user);
        }
        catch (TransactionSystemException ex) {
            throw ex;
        }catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User succesfully deleted!";
    }

    @Override
    public ArrayList<User> getByEmail(String email) {
        String userId;
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        try {
            users = (ArrayList<User>) userDao.getByEmail(email);
        }
        catch (TransactionSystemException ex) {
            throw ex;
        }catch (Exception ex) {
            throw ex;
        }
        return users;
    }

    @Override
    public String updateName(long id, String email, String name) throws TransactionSystemException {
        try {
            User user = userDao.getById(id);
            user.setEmail(email);
            user.setName(name);
            userDao.update(user);
        }
        catch (TransactionSystemException ex) {
            throw ex;
        }catch (Exception ex) {
            return "Error updating the user " + ex.toString();
        }

        return "User succesfully updated!";
    }

}
