package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {// product
    private String id;
    private String name;
    private Date snapshotDate;
    private String type;
    private Money money = new Money();

    public Product(String id, String name, Date snapshotDate, String type) {
        this.id = id;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    public String getProductId() {
        return id;
    }


    public String getProductName() {
        return name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getProductType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSnapshotDate(Date snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(snapshotDate, product.snapshotDate) &&
                Objects.equals(type, product.type) &&
                Objects.equals(money, product.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, snapshotDate, type, money);
    }
}
