package globantWorkshop.controllers;

import globantWorkshop.models.entities.User;
import globantWorkshop.models.dao.UserDao;

import globantWorkshop.services.implementation.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class UserController
 */
@Controller
public class UserController {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  // Wire the UserDao used inside this controller.

  @Autowired
  private UserDao userDao;

  @Autowired
  private LibraryService libraryService;

  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  /**
   * Get all the users
   */
  @RequestMapping(value = "/getUsers")
  @ResponseBody
  public List<User> getAllUsers() {
    return libraryService.getAllUsers();
  }

  /**
   * Create a new user with an auto-generated id and email and name as passed
   * values.
   */
  @RequestMapping(value = "/create")
  @ResponseBody
  public String create(@RequestParam(value = "email", required = true) String email,
                       @RequestParam(value = "name", required = true) String name) {
    return libraryService.create(email, name);
  }

  /**
   * Delete the user with the passed id.
   */
  @RequestMapping(value = "/delete")
  @ResponseBody
  public String delete(@RequestParam(value = "id", required = true) long id) {
    return libraryService.delete(id);
  }

  /**
   * Retrieve the id for the user with the passed email address.
   */
  @RequestMapping(value = "/getByEmail")
  @ResponseBody
  public ArrayList<User> getByEmail(@RequestParam(value = "email", required = true) String email) {
    return libraryService.getByEmail(email);
  }

  /**
   * Update the email and the name for the user indentified by the passed id.
   */
  @RequestMapping(value = "/update")
  @ResponseBody
  public String updateName(@RequestParam(value = "id", required = true) long id,
                           @RequestParam(value = "email", required = true) String email,
                           @RequestParam(value = "name", required = true) String name) {
    return libraryService.updateName(id, email, name);
  }

  @ExceptionHandler({MissingServletRequestParameterException.class,TransactionSystemException.class,IllegalArgumentException.class, NullPointerException.class})
  void handleBadRequests(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.BAD_REQUEST.value());
  }
}
