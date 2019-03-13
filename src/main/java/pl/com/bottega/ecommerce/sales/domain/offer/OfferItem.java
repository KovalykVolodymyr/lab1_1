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

    private Money totalCost;

    private Discount discount;

    private int quantity;

    // discount


    public OfferItem(Product product, Money totalCost,
             int quantity) {
        this(product, totalCost, quantity, null);
    }

    public OfferItem(Product product, Money totalCost,
            int quantity, Discount discount) {
        this.product = product;
        this.totalCost = totalCost;

        this.quantity = quantity;
        this.discount = discount;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount.getDiscount());
        }

        totalCost.setProductPrice(totalCost.getProductPrice().multiply(new BigDecimal(quantity)).subtract(discountValue));
    }

    public Product getProduct() {
        return product;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public Discount getDiscount() {
        return discount;
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

        if (quantity != offerItem.quantity)
            return false;
        if (!Objects.equals(product, offerItem.product))
            return false;
        if (!Objects.equals(totalCost, offerItem.totalCost))
            return false;
        return Objects.equals(discount, offerItem.discount);
    }

    @Override public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (totalCost != null ? totalCost.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }

    /**
     *
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (product == null) {
            if (other.product != null) {
                return false;
            }
        } else if (!product.equals(other.product)) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.getProductPrice().compareTo(other.totalCost.getProductPrice()) > 0) {
            max = totalCost.getProductPrice();
            min = other.totalCost.getProductPrice();
        } else {
            max = other.totalCost.getProductPrice();
            min = totalCost.getProductPrice();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
