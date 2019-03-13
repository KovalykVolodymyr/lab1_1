package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {

    private String cause;

    private BigDecimal value;

    public BigDecimal getDiscount() {
        return value;
    }

    public String getDiscountCause() {
        return cause;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Discount discount = (Discount) o;

        if (!Objects.equals(cause, discount.cause))
            return false;
        return Objects.equals(value, discount.value);
    }

    @Override public int hashCode() {
        int result = cause != null ? cause.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
