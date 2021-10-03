package demo.services.books_service.application;

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