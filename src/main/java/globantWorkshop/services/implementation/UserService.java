package globantWorkshop.services.implementation;

import globantWorkshop.models.entities.User;
import globantWorkshop.models.dao.UserDao;
import globantWorkshop.services.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;


import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandromaro on 23/10/16.
 */

@Service
public class UserService implements UserServiceInterface {

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
    public User create(User user) throws PersistenceException {
        userDao.create(user);
        return user;
    }

    @Override
    public String delete(int idUser) {
        User user = userDao.getById(idUser);
        userDao.delete(user);
        return "User successfully deleted!";
    }


    @Override
    public String updateUserValues(User newUser) {
        try {
            userDao.update(newUser);
            return "User successfully updated!";
        }catch (Exception ex) {
            return "Error updating the user " + ex.toString();
        }
    }


    @Override
    public User findUserById(int userId) throws TransactionSystemException {
        User user;
        try {
            user = userDao.getById(userId);
        }
        catch (TransactionSystemException ex) {
            throw ex;
        }catch (Exception ex) {
            throw ex;
        }
        return user;
    }



}
