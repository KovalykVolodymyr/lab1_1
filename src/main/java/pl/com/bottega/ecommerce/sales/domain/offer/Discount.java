package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {

    // discount
    private String discountCause;

    private Money money;

    public String getDiscountCause() {
        return discountCause;
    }

    public Money getMoney() {
        return money;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Discount discount = (Discount) o;
        return Objects.equals(discountCause, discount.discountCause) && Objects.equals(money, discount.money);
    }

    @Override public int hashCode() {
        return Objects.hash(discountCause, money);
    }

    public Discount(String discountCause, BigDecimal discount) {
        this.discountCause = discountCause;
        this.money = new Money(discount, "");
    }
}
