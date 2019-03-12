package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {

    private Money discountValue;

    private String cause;

    public Discount(Money discountValue, String cause) {
        this.discountValue = discountValue;
        this.cause = cause;
    }

    public Money getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Money discountValue) {
        this.discountValue = discountValue;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
