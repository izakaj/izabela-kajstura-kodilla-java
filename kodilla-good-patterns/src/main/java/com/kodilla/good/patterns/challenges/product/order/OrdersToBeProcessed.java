package com.kodilla.good.patterns.challenges.product.order;

import java.util.LinkedList;
import java.util.List;

public class OrdersToBeProcessed {
    List<Order> listOfOrders = new LinkedList<>();

    public boolean addOrder(Order order){
        return listOfOrders.add(order);
    }

    public List<Order> getListOfOrders() {
        return listOfOrders;
    }
}
