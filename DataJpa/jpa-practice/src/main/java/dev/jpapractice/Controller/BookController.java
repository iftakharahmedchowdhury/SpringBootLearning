package dev.jpapractice.Controller;

import dev.jpapractice.DTOs.BookDto;
import dev.jpapractice.Service.BookService;
import dev.jpapractice.model.Book;
import dev.jpapractice.model.Library;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("api/bookList")
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @PostMapping("api/bookList")
    public ResponseEntity<String> createBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book created successfully");
    }
}
