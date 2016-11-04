package globantWorkshop.controllers;

import globantWorkshop.models.entities.Book;
import globantWorkshop.services.implementation.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by leandromaro on 29/10/16.
 */
@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/getBooks")
    @ResponseBody
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    /**
     * Create a new book with an auto-generated id
     */
    @RequestMapping(value = "/createBook")
    @ResponseBody
    public String create(@RequestParam(value = "name", required = true) String name,
                         @RequestParam(value = "author", required = true) String author,
                         @RequestParam(value= "ISBN", required = true) int ISBN) {
        return bookService.create(name,author,ISBN);
    }

}
