package com.kodilla.good.patterns.challenges;


import java.util.HashMap;

public class Order {
    private User user;
    private HashMap<Product, Integer> productsOrdered;

    public Order(User user, HashMap<Product, Integer> productsOrdered) {
        this.user = user;
        this.productsOrdered = productsOrdered;
    }

    public User getUser() {
        return user;
    }

    public HashMap<Product, Integer> getProductsOrdered() {
        return productsOrdered;
    }
}
