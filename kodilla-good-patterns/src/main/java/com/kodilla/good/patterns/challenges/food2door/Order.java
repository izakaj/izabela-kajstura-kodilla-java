package com.kodilla.good.patterns.challenges.food2door;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class Order {
    private User user;
    private List<OrderedProduct> listOfOrderedProducts;

    public Order(User user, List<OrderedProduct> listOfOrderedProducts) {
        this.user = user;
        this.listOfOrderedProducts = Collections.unmodifiableList
                (new LinkedList(listOfOrderedProducts));
    }

    public User getUser() {
        return user;
    }

    public List<OrderedProduct> getListOfOrderedProducts() {
        return Collections.unmodifiableList(listOfOrderedProducts);
    }
}
