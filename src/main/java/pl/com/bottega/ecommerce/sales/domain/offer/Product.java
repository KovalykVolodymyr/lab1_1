package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {// product
    private String id;
    private BigDecimal price;
    private String name;
    private Date snapshotDate;
    private String type;

    public Product(String id, BigDecimal price, String name, Date snapshotDate, String type) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    public String getProductId() {
        return id;
    }

    public BigDecimal getProductPrice() {
        return price;
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

    public void setPrice(BigDecimal price) {
        this.price = price;
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
}
