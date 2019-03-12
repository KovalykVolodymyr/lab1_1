package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private String currency;

    private BigDecimal productPrice;

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Money money = (Money) o;

        if (!Objects.equals(currency, money.currency))
            return false;
        return Objects.equals(productPrice, money.productPrice);
    }

    @Override public int hashCode() {
        int result = currency != null ? currency.hashCode() : 0;
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        return result;
    }
}
