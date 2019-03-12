package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {

    private String id;

    private BigDecimal price;

    private String currency;

    private String name;

    private Date snapshotDate;

    private String type;

    public Product(String id, BigDecimal price, String currency, String name, Date snapshotDate, String type) {

        this.id = id;
        this.price = price;
        this.currency = currency;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;

    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getType() {
        return type;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id)
               && Objects.equals(price, product.price)
               && Objects.equals(currency, product.currency)
               && Objects.equals(name, product.name)
               && Objects.equals(snapshotDate, product.snapshotDate)
               && Objects.equals(type, product.type);
    }

    @Override public int hashCode() {
        return Objects.hash(id, price, currency, name, snapshotDate, type);
    }
}
