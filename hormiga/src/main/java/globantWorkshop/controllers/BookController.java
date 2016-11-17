package globantWorkshop.controllers;

import globantWorkshop.models.dao.BookDao;
import globantWorkshop.models.entities.Book;
import globantWorkshop.services.implementation.BookService;
import globantWorkshop.services.implementation.BookService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandromaro on 29/10/16.
 */
@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    /**
     * Create a new book with an auto-generated id
     */
    /*TODO ARREGLAR EL POST QUE NO ESTA SALIENDO*/
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Book> create(@RequestBody Book book) {

       return ResponseEntity.ok(bookService.create(book));
    }

    /**
     * Delete the user with the passed id.
     * ATTENTION: The better way to access a post request it's using a wrapper as @RequestBody parameter,
     * but, here we only want to pass the id value, so we handle the id using the JSONObject class.
     */
    /*TODO VER ELIMINAR EL BOOK*/
    @RequestMapping(value = "/{idbooks}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete (@PathVariable Integer idbooks) {
            return bookService.delete(idbooks);
    }

    /**
     * Update the book's data for the book passed as parameter.
     */
    /*TODO TAMBIEN FALTA VER EL UPDATE BOOK*/
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String updateName(@RequestBody Book bookParam){
        return bookService.updateBook(bookParam);
    }
    /*
    *  Get book with id
    */
    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    @ResponseBody
    public Book getBook(@PathVariable Integer bookId){
        return bookService.findBookById(bookId);
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
