package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {

    private String Cause;
    private Money discountValue;

    public String getCause() {
        return Cause;
    }

    public void setCause(String cause) {
        Cause = cause;
    }

    public Money getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Money discountValue) {
        this.discountValue = discountValue;
    }
}
