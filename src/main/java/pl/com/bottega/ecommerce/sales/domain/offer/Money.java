package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public Money(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Money money = (Money) o;
        return Objects.equals(value, money.value) && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    private BigDecimal value;

    private String currency;
}

