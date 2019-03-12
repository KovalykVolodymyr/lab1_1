package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {
    public BigDecimal value;
    public String currency;

    Money(BigDecimal value){
        this.value = value;
        this.currency = "$";
    }

}
