package pl.edu.agh.dronka.shop.model;

import java.util.Date;

public class Food extends Item {
    private Date expiryDate;

    public Food(String name, Category category, int price, int quantity, Date expiryDate) {
        super(name, category, price, quantity);
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}
