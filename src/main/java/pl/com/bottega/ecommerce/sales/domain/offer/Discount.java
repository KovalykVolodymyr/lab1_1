package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

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

    public Discount(String discountCause, BigDecimal discount) {
        this.discountCause = discountCause;
        this.money = new Money(discount, "");
    }
}
