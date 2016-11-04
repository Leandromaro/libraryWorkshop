package globantWorkshop.controllers;

import globantWorkshop.models.entities.User;

import globantWorkshop.services.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class UserController
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private UserService libraryService;

  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  /**
   * Get all the books
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
  @RequestMapping(value = "/create", method = { RequestMethod.POST  }, headers = {"Content-type=application/json"})
  @ResponseBody
  public String create(@RequestBody String name,
                       @RequestBody String lastname,
                       @RequestBody String email,
                       @RequestBody int dni,
                       @RequestBody String address,
                       @RequestBody String phone) {


   return libraryService.create(name, lastname, email, dni, address,phone);
  }

//  @RequestMapping(method = RequestMethod.POST)
//  ResponseEntity<?> add(@PathVariable String userId, @RequestBody Bookmark input) {
//    this.validateUser(userId);
//    return this.accountRepository
//            .findByUsername(userId)
//            .map(account -> {
//              Bookmark result = bookmarkRepository.save(new Bookmark(account,
//                      input.uri, input.description));
//
//              HttpHeaders httpHeaders = new HttpHeaders();
//              httpHeaders.setLocation(ServletUriComponentsBuilder
//                      .fromCurrentRequest().path("/{id}")
//                      .buildAndExpand(result.getId()).toUri());
//              return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
//            }).get();
//
//  }

  /**
   * Delete the user with the passed id.
   */
  @RequestMapping(value = "/delete")
  @ResponseBody
  public String delete(@RequestParam(value = "id", required = true) int id) {
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

  //revisar values
  public String updateName(@RequestParam(value = "id", required = true) int id,
                           @RequestParam(value = "email", required = true) String email,
                           @RequestParam(value = "name", required = true) String name) {
    return libraryService.updateName(id, email, name);
  }

  @ExceptionHandler({MissingServletRequestParameterException.class,TransactionSystemException.class,IllegalArgumentException.class, NullPointerException.class})
  void handleBadRequests(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.BAD_REQUEST.value());
  }
}
