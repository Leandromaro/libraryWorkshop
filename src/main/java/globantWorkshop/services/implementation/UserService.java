package globantWorkshop.services.implementation;

import globantWorkshop.models.entities.User;
import globantWorkshop.models.dao.UserDao;
import globantWorkshop.services.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;


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
    public String create(String name, String lastname, String email, Integer dni,String address,String phone) {
        try {
            User user = new User(name, lastname, email, dni, address, phone);
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
    public String delete(int idusers) {
        User user = new User();
        try {
            user = userDao.getById(idusers);
            userDao.delete(user);
        }catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User succesfully deleted!";
    }

    @Override
    public ArrayList<User> getByEmail(String email) {
        ArrayList<User> users = new ArrayList<>();
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
    public String updateName(int id, String email, String name) throws TransactionSystemException {
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
