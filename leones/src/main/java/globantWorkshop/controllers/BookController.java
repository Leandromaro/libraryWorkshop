package globantWorkshop.controllers;

import globantWorkshop.models.entities.Book;
import globantWorkshop.services.implementation.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by leandromaro on 29/10/16.
 */
@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService libraryService;

    /**
     * Get all the books
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getAllBooks(){
        return libraryService.getAllBooks();
    }

    /**
     * Create a new book with an auto-generated id
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Book> create(@RequestBody Book bookParam) throws PersistenceException {
        Book book = libraryService.create(bookParam);
        return new ResponseEntity<Book>(book, HttpStatus.CREATED);
    }
    /**
     * Delete the user with the passed id.
     * ATTENTION: The better way to access a post request it's using a wrapper as @RequestBody parameter,
     * but, here we only want to pass the id value, so we handle the id using the JSONObject class.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete (@PathVariable Integer bookId) {
        //Should Be implemented
        return "Should Be implemented";
    }

    /**
     * Update the book's data for the book passed as parameter.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateName(@PathVariable Integer bookId, @RequestBody Book bookParam){
        return libraryService.updateBook(bookParam);
    }
    /**
     * Method created to handle the controller's exceptions, so the malformed request are responded in the controller layer
     * @param response HttpStatus.BAD_REQUEST
     * @throws IOException
     */
    @ExceptionHandler({MissingServletRequestParameterException.class,TransactionSystemException.class,IllegalArgumentException.class, NullPointerException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
