package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {

    private String productId;

    private String productName;

    private String productType;

    private Date productSnapshotDate;

    private BigDecimal price;

    public Product(String productId, String productName, String productType, Date productSnapshotDate, BigDecimal price) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.productSnapshotDate = productSnapshotDate;
        this.price = price;
    }

    public String getProductId() { return productId; }

    public String getProductName() { return productName; }

    public Date getProductSnapshotDate() { return productSnapshotDate; }

    public String getProductType() { return productType; }

    public BigDecimal getPrice() { return price; }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) && Objects.equals(productName, product.productName) && Objects.equals(
                productType, product.productType) && Objects.equals(productSnapshotDate, product.productSnapshotDate) && Objects.equals(
                price, product.price);
    }

    @Override public int hashCode() {
        return Objects.hash(productId, productName, productType, productSnapshotDate, price);
    }
}
