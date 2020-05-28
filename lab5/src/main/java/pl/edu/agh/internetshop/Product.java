package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class Product {
	
	public static final int PRICE_PRECISION = 2;
	public static final int ROUND_STRATEGY = BigDecimal.ROUND_HALF_UP;
	
    private final String name;
    private final BigDecimal price;
    private final BigDecimal discount;

    public Product(String name, BigDecimal price, BigDecimal discount) {
        if (discount == null)
            throw new NullPointerException("Discount cannot be null");
        if (discount.equals(BigDecimal.ZERO))
            throw new IllegalArgumentException("Discount must be greater than zero");

        this.name = name;
        this.price = price;
        this.price.setScale(PRICE_PRECISION, ROUND_STRATEGY);
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPriceWithoutDiscount() {
        return price;
    }

    public BigDecimal getPriceWithDiscount() {
        return price.multiply(discount);
    }

    public BigDecimal getDiscount() {
        return discount;
    }
}
