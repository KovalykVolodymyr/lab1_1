package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {

    private String productId;
    private String productName;

    private Money price;
    private Date productSnapshotDate;
    private String productType;

    public Product(String productId, String productName, Date productSnapshotDate, String productType){
        this.productId = productId;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
    }


    public Money getPrice() { return price; }

    public void setPrice(Money price) { this.price = price; }

    public String getProductId() { return productId; }

    public String getProductName() { return productName; }

    public Date getProductSnapshotDate() { return productSnapshotDate; }

    public String getProductType() { return productType; }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) && Objects.equals(
                productName, product.productName) && Objects.equals(price, product.price) && Objects.equals(productSnapshotDate,
                product.productSnapshotDate) && Objects.equals(productType, product.productType);
    }

    @Override public int hashCode() {
        return Objects.hash(productId, productName, price, productSnapshotDate, productType);
    }

}
