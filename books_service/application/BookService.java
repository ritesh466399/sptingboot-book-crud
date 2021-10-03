package demo.services.books_service.application;

import demo.services.books_service.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();

    Book getBook(String bookId);

    void addBook(Book book);

    void updateBook(String bookId, Book book);

    void deleteBook(String bookId);

    double checkoutBook(Book[] books);
}
