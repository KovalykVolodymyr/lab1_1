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

public class OfferItem {

    private Discount discount;

    private  Money money;

    private  Product product;

    private int quantity;

    public OfferItem(Product product, int quantity, Discount discount, Money money) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
        this.money = money;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount.getMoney().getValue());
        }

        this.money.setValue(product.getMoney().getValue().multiply(new BigDecimal(quantity)).subtract(discountValue));
    }


    public int getQuantity() {
        return quantity;
    }


    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discount.getMoney().getValue() == null ? 0 : discount.getMoney().getValue().hashCode());
        result = prime * result + (product.getProductName() == null ? 0 : product.getProductName().hashCode());
        result = prime * result + (product.getMoney().getValue() == null ? 0 : product.getMoney().getValue().hashCode());
        result = prime * result + (product.getProductId() == null ? 0 : product.getProductId().hashCode());
        result = prime * result + (product.getProductType() == null ? 0 : product.getProductType().hashCode());
        result = prime * result + quantity;
        result = prime * result + (money.getValue() == null ? 0 : money.getValue().hashCode());
        return result;
    }

    /**
     *
     * @param other
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (product.getProductName() == null) {
            if (other.product.getProductName() != null) {
                return false;
            }
        } else if (!product.getProductName().equals(other.product.getProductName())) {
            return false;
        }
        if (product.getMoney().getValue() == null) {
            if (other.product.getMoney().getValue() != null) {
                return false;
            }
        } else if (!product.getMoney().getValue().equals(other.product.getMoney().getValue())) {
            return false;
        }
        if (product.getProductId() == null) {
            if (other.product.getProductId() != null) {
                return false;
            }
        } else if (!product.getProductId().equals(other.product.getProductId())) {
            return false;
        }
        if (product.getProductType() != other.product.getProductType()) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (money.getValue().compareTo(other.money.getValue()) > 0) {
            max = money.getValue();
            min = other.money.getValue();
        } else {
            max = other.money.getValue();
            min = money.getValue();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
