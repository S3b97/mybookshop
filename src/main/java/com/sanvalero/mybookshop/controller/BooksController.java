package com.sanvalero.mybookshop.controller;


import com.sanvalero.mybookshop.domain.Books;
import com.sanvalero.mybookshop.exception.BooksNotFoundException;
import com.sanvalero.mybookshop.service.BooksService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sanvalero.mybookshop.controller.Response.NOT_FOUND;
import java.util.Set;

@RestController
@Tag(name = "books", description = "lista")
public class BooksController {


    @Autowired
    BooksService booksService;

    @GetMapping(value = "/books", produces = "application/json")
    public ResponseEntity<Set<Books>> getBooks(@RequestParam(value = "category", defaultValue = "")String category){

        Set<Books> books = null;
        if (category.equals(""))
            books = booksService.findAll();
        else
            books = booksService.findByCategory(category);
        return new ResponseEntity<>(books, HttpStatus.OK);


    }


@GetMapping(value = "/books/{id}", produces = "application/json")
public ResponseEntity<Books> getBook(@PathVariable long id){
        Books book = booksService.findById(id).orElseThrow(() -> new BooksNotFoundException(id));
        return new ResponseEntity<>(book, HttpStatus.OK);
}

@PostMapping(value = "/books", produces = "application/json")
public ResponseEntity<Books> addBook(@RequestBody Books book) {

        Books addedBook= booksService.addBook(book);
        return new ResponseEntity<>(addedBook, HttpStatus.OK);

}


@PutMapping(value = "/books{id}", produces = "application/json", consumes = "application/json")
public ResponseEntity<Books> modifyBook(@PathVariable long id, @RequestBody Books newBook){
        Books books = booksService.modifyBook(id, newBook);
        return new ResponseEntity<>(books, HttpStatus.OK);
}


@DeleteMapping(value = "/books{id}", produces = "application/json")
public ResponseEntity<Response> deleteBook(@PathVariable long id){
        booksService.deleteBook(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
}


@GetMapping(value = "/books{title}", produces = "application/json")
public ResponseEntity<Books> getBook(@PathVariable String title){
Books book = booksService.findByTitle(title);

return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @ExceptionHandler(BooksNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handlerException(BooksNotFoundException pnfe){
        Response response = Response.errorResponse(NOT_FOUND, pnfe.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}
