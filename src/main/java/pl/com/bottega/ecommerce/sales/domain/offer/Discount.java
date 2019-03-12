package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Objects;

public class Discount {

    private Money discountValue;

    private String cause;

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Discount discount = (Discount) o;
        return Objects.equals(getDiscountValue(), discount.getDiscountValue()) && Objects.equals(getCause(), discount.getCause());
    }

    @Override public int hashCode() {
        return Objects.hash(getDiscountValue(), getCause());
    }

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
