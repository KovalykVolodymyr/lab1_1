package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {

    public String getDiscountCause() {
        return discountCause;
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

    public void setDiscountCause(String discountCause) {
        this.discountCause = discountCause;
    }

    private String discountCause;
    private Money money;

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }


    public Discount(String discountCause, BigDecimal discount) {
        this.discountCause = discountCause;
        this.money = new Money(discount);
    }


}
