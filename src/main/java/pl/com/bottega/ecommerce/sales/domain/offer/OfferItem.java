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
package pl.weeia.makz21.offer;

import pl.com.bottega.ecommerce.sales.domain.offer.Product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OfferItem {

    private int quantity;

    private BigDecimal totalCost;

    private String currency;

    // discount
    private String discountCause;

    private BigDecimal discount;

    private Product product;

    public OfferItem(Product product,
            int quantity) {
        this(product, quantity, null, null);
    }

    public OfferItem(Product product, int quantity, BigDecimal discount, String discountCause) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
        this.discountCause = discountCause;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount);
        }

        this.totalCost = product.getPrice().multiply(new BigDecimal(quantity)).subtract(discountValue);
    }


    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public String getTotalCostCurrency() {
        return currency;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override public int hashCode() {
        return Objects.hash(getQuantity(), getTotalCost(), currency, getDiscountCause(), getDiscount(), product);
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof OfferItem))
            return false;
        OfferItem offerItem = (OfferItem) o;
        return getQuantity() == offerItem.getQuantity() && Objects.equals(getTotalCost(), offerItem.getTotalCost()) && Objects.equals(
                currency, offerItem.currency) && Objects.equals(getDiscountCause(), offerItem.getDiscountCause()) && Objects.equals(
                getDiscount(), offerItem.getDiscount()) && Objects.equals(product, offerItem.product);
    }

    /**
     * @param item
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (productName == null) {
            if (other.productName != null) {
                return false;
            }
        } else if (!productName.equals(other.productName)) {
            return false;
        }
        if (productPrice == null) {
            if (other.productPrice != null) {
                return false;
            }
        } else if (!productPrice.equals(other.productPrice)) {
            return false;
        }
        if (productId == null) {
            if (other.productId != null) {
                return false;
            }
        } else if (!productId.equals(other.productId)) {
            return false;
        }
        if (productType != other.productType) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.compareTo(other.totalCost) > 0) {
            max = totalCost;
            min = other.totalCost;
        } else {
            max = other.totalCost;
            min = totalCost;
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
