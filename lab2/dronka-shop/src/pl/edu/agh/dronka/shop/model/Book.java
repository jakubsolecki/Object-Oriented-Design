package pl.edu.agh.dronka.shop.model;

public class Book extends Item {
    private boolean hardCase;
    private int pages;

    public Book(String name, Category category, int price, int quantity, int pages, boolean hardCase){
        super(name, category, price, quantity);
        this.hardCase = hardCase;
        this.pages = pages;
    }

    public Book() {}

    public boolean isHardCase() {
        return hardCase;
    }

    public int getPages() {
        return pages;
    }

    public void setHardCase(boolean hardCase) {
        this.hardCase = hardCase;
    }
}
