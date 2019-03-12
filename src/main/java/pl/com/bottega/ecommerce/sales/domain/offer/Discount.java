package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {

    private String cause;
    private int value;

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
