package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {

    private String id;

    private BigDecimal price;

    private String name;

    private Date snapshotDate;

    private String productType;

    public Product(String id, BigDecimal price, String name, Date snapshotDate, String productType) {
        this.id = id;
        this.price = price;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        return Objects.equals(getId(), product.getId()) && Objects.equals(getPrice(), product.getPrice()) && Objects.equals(getName(),
                product.getName()) && Objects.equals(getSnapshotDate(), product.getSnapshotDate()) && Objects.equals(getProductType(),
                product.getProductType());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getPrice(), getName(), getSnapshotDate(), getProductType());
    }
}
