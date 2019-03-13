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
import java.util.Objects;

public class OfferItem {

    private Product product;

    private int quantity;

    private Money totalCost;

    private Discount discount;

    public OfferItem(Product product, int quantity) {
        this(product, quantity, null);
    }

    public OfferItem(Product product, int quantity, Discount discount) {

        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
        this.totalCost = new Money();

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount.getValue().getValue());
        }

        totalCost.setValue(product.getPrice().getValue().multiply(new BigDecimal(quantity)).subtract(discountValue));
        totalCost.setCurrency(product.getPrice().getCurrency());
    }

    public Product getProduct() {
        return product;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        OfferItem offerItem = (OfferItem) o;
        return quantity == offerItem.quantity && Objects.equals(product, offerItem.product) && Objects.equals(totalCost,
                offerItem.totalCost) && Objects.equals(discount, offerItem.discount);
    }

    @Override public int hashCode() {
        return Objects.hash(product, quantity, totalCost, discount);
    }

    /**
     * @param other
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {

        if (!this.getProduct().equals(other.getProduct())) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        Money max;
        Money min;
        if (totalCost.getValue().compareTo(other.totalCost.getValue()) > 0) {
            max = totalCost;
            min = other.totalCost;
        } else {
            max = other.totalCost;
            min = totalCost;
        }

        BigDecimal difference = max.getValue().subtract(min.getValue());
        BigDecimal acceptableDelta = max.getValue().multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
