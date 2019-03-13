package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Objects;

public class Discount {

    private String Cause;

    private Money value;

    public Discount(String cause, Money value) {
        Cause = cause;
        this.value = value;
    }

    public String getCause() {
        return Cause;
    }

    public Money getValue() {
        return value;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Discount discount = (Discount) o;
        return Objects.equals(Cause, discount.Cause) && Objects.equals(value, discount.value);
    }

    @Override public int hashCode() {
        return Objects.hash(Cause, value);
    }
}
