package pl.edu.agh.dronka.shop.model;

public class Electronics extends Item {
    private boolean mobile;
    private boolean warranty;

    public Electronics(String name, Category category, int price, int quantity, boolean mobile, boolean warranty) {
        super(name, category, price, quantity);
        this.mobile = mobile;
        this.warranty = warranty;
    }

    public Electronics() { }

    public boolean isMobile() {
        return mobile;
    }

    public boolean isWarranty() {
        return warranty;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }
}
