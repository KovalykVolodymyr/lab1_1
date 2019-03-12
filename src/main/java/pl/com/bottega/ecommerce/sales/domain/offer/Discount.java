package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {
    private String discountCause;
    private BigDecimal discount;
    private Money money;

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Discount discount1 = (Discount) o;
        return Objects.equals(discountCause, discount1.discountCause) && Objects.equals(discount, discount1.discount) && Objects.equals(
                money, discount1.money);
    }

    @Override public int hashCode() {
        return Objects.hash(discountCause, discount, money);
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }


    public Discount(String discountCause, BigDecimal discount) {
        this.discountCause = discountCause;
        this.discount = discount;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public void setDiscountCause(String discountCause) {
        this.discountCause = discountCause;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

}
