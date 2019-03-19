package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {

    private String discountCause;
    private Money value;

    public Discount(String discountCause, BigDecimal discount) {
        this.discountCause = discountCause;
        this.value = new Money(discount);
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public void setDiscountCause(String discountCause) {
        this.discountCause = discountCause;
    }

    public Money getMoney() {
        return value;
    }

    public void setMoney(Money money) {
        this.value = money;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Discount discount = (Discount) o;
        return Objects.equals(discountCause, discount.discountCause) && Objects.equals(value, discount.value);
    }

    @Override public int hashCode() {
        return Objects.hash(discountCause, value);
    }

}
