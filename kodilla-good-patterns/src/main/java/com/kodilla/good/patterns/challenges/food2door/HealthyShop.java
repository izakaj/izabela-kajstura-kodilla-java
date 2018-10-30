package com.kodilla.good.patterns.challenges.food2door;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class HealthyShop implements Producer {

    private String producerName = "HealthyShop";
    private String producerAddress = "12 Grimmauld Place, London";

    public boolean process(List<OrderedProduct> orderFromProducer){
        System.out.println("HealthyShop has heard your request. You will receive: ");
        for (OrderedProduct orderedProduct : orderFromProducer){
            System.out.println(orderedProduct.getProduct().getProductName() + " - " +
                    orderedProduct.getQuantity());
            System.out.println("The order is processed by HealthyShop.");
        }
        return true;
    }
}
