package com.kodilla.good.patterns.challenges.food2door;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ExtraFoodShop implements Producer {

    private String producerName = "ExtraFoodShop";
    private String producerAddress = "Diagon Alley 93, London";

    public boolean process(List<OrderedProduct> orderFromProducer){
        System.out.println("Products from ExtraFoodShop are on their way!");
        for (OrderedProduct orderedProduct : orderFromProducer){
            System.out.println("The order is processed by HealthyShop.");
        }
        return true;
    }

    public String getProducerName() {
        return producerName;
    }

    public String getProducerAddress() {
        return producerAddress;
    }
}
