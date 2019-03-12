package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {

    private String cause;

    private BigDecimal value;

    public Money money;

    public Discount(String cause, BigDecimal value){

        this.cause = cause;
        this.value = value;
    }

    public String getCause() {
        return cause;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (value == null ? 0 : value.hashCode());

        return result;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Discount discount = (Discount) o;
        return Objects.equals(cause, discount.cause) && Objects.equals(value, discount.value);
    }
}
