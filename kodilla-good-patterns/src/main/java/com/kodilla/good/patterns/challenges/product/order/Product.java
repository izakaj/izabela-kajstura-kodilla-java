package com.kodilla.good.patterns.challenges.product.order;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private int productId;
    private String productName;
    private BigDecimal productPrice;

    public Product(int productId, String productName, BigDecimal productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productPrice, product.productPrice);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productPrice);
    }
}
