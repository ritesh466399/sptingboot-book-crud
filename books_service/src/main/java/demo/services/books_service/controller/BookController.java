package demo.services.books_service.controller;

import demo.services.books_service.domain.Book;
import demo.services.books_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookservice;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookservice.getAllBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        return bookservice.getBook(bookId);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        bookservice.addBook(book);
    }

    @PutMapping("/books")
    public void updateBook(@RequestBody Book book) {
        bookservice.updateBook(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long bookId) {
        bookservice.deleteBook(bookId);
    }

    @PostMapping("/books/checkout")
    public double checkoutBook(@RequestBody Book[] books) {
        return bookservice.checkoutBook(books);
    }
}
