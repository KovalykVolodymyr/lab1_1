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

    // product
    private Product product;

    private int quantity;

    private Money money;

    private Discount discount;


    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate,
            String productType, int quantity) {
        this(productId, productPrice, productName, productSnapshotDate, productType, quantity, null, null);
    }

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate,
            String productType, int quantity, BigDecimal discount, String discountCause) {

        this.quantity = quantity;
        this.product = new Product(productId, productPrice, productName, productSnapshotDate, productType);

        BigDecimal discountValue = new BigDecimal(0);
        this.discount = new Discount(discountCause, discountValue.subtract(discount));

        this.money = new Money(productPrice.multiply(new BigDecimal(quantity)).subtract(this.discount.getDiscount()));
    }

    public String getProductId() {
        return product.getProductId();
    }

    public BigDecimal getProductPrice() { return product.getProductPrice(); }

    public String getProductName() {
        return product.getProductName();
    }

    public Date getProductSnapshotDate() {
        return product.getProductSnapshotDate();
    }

    public String getProductType() {
        return product.getProductType();
    }

    public BigDecimal getTotalCost() { return this.money.getValue(); }

    public String getTotalCostCurrency() { return this.money.getCurrency(); }

    public BigDecimal getDiscount() {
        return discount.getDiscount();
    }

    public String getDiscountCause() {
        return discount.getDiscountCause();
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
        return quantity == offerItem.quantity
               && Objects.equals(product, offerItem.product)
               && Objects.equals(money, offerItem.money)
               && Objects.equals(discount, offerItem.discount);
    }

    @Override public int hashCode() {
        return Objects.hash(product, quantity, money, discount);
    }

    /**
     *
     * @param // item
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (!product.equals(other)) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (getTotalCost().compareTo(other.getTotalCost()) > 0) {
            max = getTotalCost();
            min = other.getTotalCost();
        } else {
            max = other.getTotalCost();
            min = getTotalCost();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
