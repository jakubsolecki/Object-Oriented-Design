package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


public class Order {
    private static final BigDecimal TAX_VALUE = BigDecimal.valueOf(1.23); // was 1.22
	private final UUID id;
    private final List<Product> products;
    private boolean paid;
    private final BigDecimal discount;
    private Shipment shipment;
    private ShipmentMethod shipmentMethod;
    private PaymentMethod paymentMethod;

    public Order(List<Product> products, BigDecimal discount) {
        if (products == null)
            throw new NullPointerException("List cannot be null");

        if (products.isEmpty())
            throw new IllegalArgumentException("List cannot be empty");

        if (discount == null)
            throw new NullPointerException("Discount cannot be null");

        if (discount.equals(BigDecimal.valueOf(0)))
            throw new IllegalArgumentException("Discount must be grater than zero");

        this.products = products;
        id = UUID.randomUUID();
        paid = false;
        this.discount = discount;
    }

    public UUID getId() {
        return id;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isSent() {
        return shipment != null && shipment.isShipped();
    }

    public boolean isPaid() { return paid; }

    public Shipment getShipment() {
        return shipment;
    }

    public BigDecimal getPrice() {
        return this.products
                .stream()
                .map(Product::getPriceWithoutDiscount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getPriceWithTaxes() {
        return getPrice().multiply(TAX_VALUE).setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY);
    }

    public BigDecimal getPriceWithDiscountAndWithTaxes() {
        return products
                .stream()
                .map(Product::getPriceWithDiscount)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(discount)
                .multiply(TAX_VALUE);
    }

    public BigDecimal getPriceWithoutDiscountAndWithTaxes() {
        return products
                .stream()
                .map(Product::getPriceWithDiscount)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(TAX_VALUE);
    }


    public List<Product> getProducts() {
        return this.products;
    }

    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public void send() {
        boolean sentSuccesful = getShipmentMethod().send(shipment, shipment.getSenderAddress(), shipment.getRecipientAddress());
        shipment.setShipped(sentSuccesful);
    }

    public void pay(MoneyTransfer moneyTransfer) {
        moneyTransfer.setCommitted(getPaymentMethod().commit(moneyTransfer));
        paid = moneyTransfer.isCommitted();
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public BigDecimal getDiscount() {
        return discount;
    }
}
