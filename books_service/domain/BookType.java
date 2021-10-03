package demo.services.books_service.domain;

public enum BookType {
    fuctio(10), COMIC(0);
    private int discount;

    private BookType(int discount) {
        this.discount = discount;
    }

}

