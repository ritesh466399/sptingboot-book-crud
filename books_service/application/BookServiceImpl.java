package demo.services.books_service.application;

import demo.services.books_service.domain.Book;
import demo.services.books_service.infrastructure.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public Book getBook(String id) {
        return bookRepository.findById(id).orElseGet(Book::new);
    }

    public void addBook(Book whiskey) {
        bookRepository.save(whiskey);
    }

    public void updateBook(String id, Book whiskey) {
        bookRepository.save(whiskey);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public double checkoutBook(Book[] books) {
        double price = 0;
            for(Book book : books) {
                DiscountType discountType = DiscountType.valueOf(book.getClassification());
                if(discountType != null) {//discount exists
                    price += book.getPrice() * (100 - discountType.getValue()) / 100;
                }
            }

        return price;
    }


}
