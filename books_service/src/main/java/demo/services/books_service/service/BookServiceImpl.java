package demo.services.books_service.service;

import demo.services.books_service.domain.Book;
import demo.services.books_service.infrastructure.persistence.BookRepository;
import demo.services.books_service.util.DiscountType;
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

    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseGet(Book::new);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public double checkoutBook(Book[] books) {
        double price = 0;
            for(Book book : books) {
                DiscountType discountType = DiscountType.valueOf(book.getClassification());
                if(discountType != null) {//discount exists
                    price += book.getPrice() * (100 - discountType.getValue()) / 100;
                } else {
                    price += book.getPrice();
                }
            }

        return price;
    }


}
