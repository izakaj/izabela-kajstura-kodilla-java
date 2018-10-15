package com.kodilla.good.patterns.challenges.food2door;

import java.util.LinkedList;
import java.util.List;

public final class Order {
    private User user;
    private List<OrderedProduct> listOfOrderedProducts = new LinkedList<>();

    public Order(User user, List<OrderedProduct> listOfOrderedProducts) {
        this.user = user;
        this.listOfOrderedProducts = listOfOrderedProducts;
    }

    public User getUser() {
        return user;
    }

    public List<OrderedProduct> getListOfOrderedProducts() {
        return listOfOrderedProducts;
    }
}
