package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;
import java.util.Objects;

public class Product {

    private String Id;

    private Money Price;

    private String Name;

    private Date SnapshotDate;

    private String Type;

    public Product(String Id, Money price, String Name, Date SnapshotDate, String Type) {
        this.Id = Id;
        this.Price = price;
        this.Name = Name;
        this.SnapshotDate = SnapshotDate;
        this.Type = Type;

    }

    public String getId() {
        return Id;
    }

    public Money getPrice() {
        return Price;
    }

    public String getName() {
        return Name;
    }

    public Date getSnapshotDate() {
        return SnapshotDate;
    }

    public String getType() {
        return Type;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(Id, product.Id) && Objects.equals(Price, product.Price) && Objects.equals(Name, product.Name) &&
               Objects.equals(SnapshotDate, product.SnapshotDate) && Objects.equals(Type, product.Type);
    }

    @Override public int hashCode() {
        return Objects.hash(Id, Price, Name, SnapshotDate, Type);
    }
}
