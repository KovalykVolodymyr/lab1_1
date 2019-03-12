package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {// product
    private String id;
    private String name;
    private Date snapshotDate;
    private String type;
    private Money money;

    public Product(String id, String name, Date snapshotDate, String type, Money money) {
        this.id = id;
        this.money = money;
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
}
