package com.kodilla.good.patterns.challenges.product.order;


import java.util.HashMap;
import java.util.Map;

public class Order {
    private User user;
    private Map<Product, Integer> productsOrdered;

    public Order(User user, Map<Product, Integer> productsOrdered) {
        this.user = user;
        this.productsOrdered = productsOrdered;
    }

    public User getUser() {
        return user;
    }

    public Map<Product, Integer> getProductsOrdered() {
        return productsOrdered;
    }
}
