package demo.services.books_service.util;

public enum DiscountType {
    FICTION(10), COMIC(0);
    private int value;
    DiscountType(int val) {
        this.value=val;
    }

    public int getValue() {
        return value;
    }
};