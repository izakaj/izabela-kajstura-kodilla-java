package com.kodilla.good.patterns.challenges.food2door;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class HealthyShop implements Producer {

    private String producerName = "HealthyShop";
    private String producerAddress = "12 Grimmauld Place, London";
    List<OrderedProduct> productsOrderedFromProducer = new LinkedList<>();

    public boolean process(List<OrderedProduct> orderFromProducer){
        System.out.println("HealthyShop has heard your request. You will receive: ");
        for (OrderedProduct orderedProduct : orderFromProducer){
            System.out.println(orderedProduct.getProduct().getProductName() + " - " +
                    orderedProduct.getQuantity());
            productsOrderedFromProducer.add(orderedProduct);
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthyShop that = (HealthyShop) o;
        return Objects.equals(producerName, that.producerName) &&
                Objects.equals(producerAddress, that.producerAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producerName, producerAddress);
    }
}
