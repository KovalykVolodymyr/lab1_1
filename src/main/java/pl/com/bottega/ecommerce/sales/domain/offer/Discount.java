package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {

    private String cause;
    private Money money;

    public Discount(String cause, Money money) {
        this.cause = cause;
        this.money = money;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }
}
