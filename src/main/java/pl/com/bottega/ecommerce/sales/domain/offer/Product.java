package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {
    private String id;

    private Money price;

    private String name;

    private Date snapshotDate;

    private String type;

    public Product(String id, BigDecimal price, String name, Date snapshotDate, String type){
        this.id = id;
        this.price = new Money(price,"PLN");
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price.getValue();
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
        return Objects.equals(id, product.id) && Objects.equals(price, product.price) && Objects.equals(name, product.name) &&
                Objects.equals(snapshotDate, product.snapshotDate) && Objects.equals(type, product.type);
    }

    @Override public int hashCode() {
        return Objects.hash(id, price, name, snapshotDate, type);
    }
}
