package com.kodilla.good.patterns.challenges.food2door;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class GlutenFreeShop implements Producer {

    private String producerName = "GlutenFreeShop";
    private String producerAddress = "Leavesden, WD25 7LR";

    public boolean process(List<OrderedProduct> orderFromProducer){
        System.out.println("GlutenFreeShop at your service.");
        for (OrderedProduct orderedProduct : orderFromProducer){
            System.out.println("The order is processed by GlutenFreeShop.");
        }
        return true;
    }
}
