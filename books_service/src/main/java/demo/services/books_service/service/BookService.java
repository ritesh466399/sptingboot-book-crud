package demo.services.books_service.service;

import demo.services.books_service.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();

    Book getBook(Long bookId);

    void addBook(Book book);

    void updateBook( Book book);

    void deleteBook(Long bookId);

    double checkoutBook(Book[] books);
}
