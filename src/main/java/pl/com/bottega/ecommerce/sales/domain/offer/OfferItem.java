/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OfferItem {

    private Product product;

    private Discount discount;

    private Money totalCost;

    private int quantity;

    public OfferItem(Product product, int quantity) {
        this(product, quantity, null);
    }

    public OfferItem(Product product, int quantity, Discount discount) {
        this.quantity = quantity;
        this.discount = discount;
        this.product = product;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount.getDiscountValue().getValue());
        }

        this.totalCost = new Money(product.getPrice().getCurrency(),
                product.getPrice().getValue().multiply(new BigDecimal(quantity)).subtract(discountValue));

    }

    public Discount getDiscount() {
        return discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Money totalCost) {
        this.totalCost = totalCost;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof OfferItem))
            return false;
        OfferItem offerItem = (OfferItem) o;
        return getQuantity() == offerItem.getQuantity() && Objects.equals(getProduct(), offerItem.getProduct()) && Objects.equals(
                getDiscount(), offerItem.getDiscount()) && Objects.equals(getTotalCost(), offerItem.getTotalCost());
    }

    @Override public int hashCode() {
        return Objects.hash(getProduct(), getDiscount(), getTotalCost(), getQuantity());
    }

    /**
     * @param other
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (!product.equals(other.product))
            return false;

        if (quantity != other.quantity) {
            return false;
        }

        return sameDeltaAs(other, delta);
    }

    private boolean sameDeltaAs(OfferItem other, double delta) {
        BigDecimal max;
        BigDecimal min;
        if (totalCost.getValue().compareTo(other.totalCost.getValue()) > 0) {
            max = totalCost.getValue();
            min = other.totalCost.getValue();
        } else {
            max = other.totalCost.getValue();
            min = totalCost.getValue();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }
}
