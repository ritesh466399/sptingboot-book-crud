package demo.services.books_service.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Book {

    @Id
    private Long id ;
    private String name = "";
    private String Description = "";

    public Book(Long id, String name, String description, String author, String classification, double price, String isbn) {
        this.id = id;
        this.name = name;
        Description = description;
        this.author = author;
        this.classification = classification;
        this.price = price;
        this.isbn = isbn;
    }

    private String author = "";
    private String classification = "";
    private double price = 0;
    private String isbn = "";



    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
