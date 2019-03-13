package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {

    private String productId;

    private String productName;

    private String productType;

    private Date productSnapshotDate;

    private Money productPrice;

    public String getProductId() {
        return productId;
    }

    public Product(String productId, String productName, String productType, Date productSnapshotDate) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.productSnapshotDate = productSnapshotDate;
    }

    public String getProductName() {
        return productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }

    public Money getProductPrice() {
        return productPrice;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Product product = (Product) o;

        if (!Objects.equals(productId, product.productId))
            return false;
        if (!Objects.equals(productName, product.productName))
            return false;
        if (!Objects.equals(productType, product.productType))
            return false;
        return Objects.equals(productSnapshotDate, product.productSnapshotDate);
    }

    @Override public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (productSnapshotDate != null ? productSnapshotDate.hashCode() : 0);
        return result;
    }
}
