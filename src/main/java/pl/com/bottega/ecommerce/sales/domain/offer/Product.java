package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {

    private String id;
    private Money money;

    private String name;

    private Date snapshotDate;

    private String productType;

    public Product(String id, Money money, String name, Date snapshotDate, String productType) {
        this.id = id;
        this.money = money;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.productType = productType;
    }

    public String getId() {
        return id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(Date snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) && Objects.equals(getMoney(), product.getMoney()) && Objects.equals(getName(),
                product.getName()) && Objects.equals(getSnapshotDate(), product.getSnapshotDate()) && Objects.equals(getProductType(),
                product.getProductType());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getMoney(), getName(), getSnapshotDate(), getProductType());
    }
}
