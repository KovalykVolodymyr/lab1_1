package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

    private BigDecimal value;

    private String discountCause;

    private String currency;

    public Discount(BigDecimal value, String discountCause, String currency) {

        this.value = value;
        this.discountCause = discountCause;
        this.currency = currency;

    }

    public BigDecimal getValue() {
        return value;
    }

    public String getDiscountCause() {
        return discountCause;
    }

}
