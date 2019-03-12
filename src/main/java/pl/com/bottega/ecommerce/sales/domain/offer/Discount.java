package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {

    private Money value;

    private String discountCause;

    public Discount(Money value, String discountCause) {

        this.value = value;
        this.discountCause = discountCause;

    }

    public Money getValue() {
        return value;
    }

    public String getDiscountCause() {
        return discountCause;
    }

}
