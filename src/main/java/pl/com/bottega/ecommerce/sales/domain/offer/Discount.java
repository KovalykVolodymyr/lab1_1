package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {

    private String cause;

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    private Money money;

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }


}
