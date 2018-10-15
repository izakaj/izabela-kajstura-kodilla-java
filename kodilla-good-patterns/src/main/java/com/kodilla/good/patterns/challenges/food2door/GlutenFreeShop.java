package com.kodilla.good.patterns.challenges.food2door;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class GlutenFreeShop implements Producer {

    private String producerName = "GlutenFreeShop";
    private String producerAddress = "Leavesden, WD25 7LR";
    List<OrderedProduct> productsOrderedFromProducer = new LinkedList<>();

    public boolean process(List<OrderedProduct> orderFromProducer){
        System.out.println("GlutenFreeShop at your service.");
        for (OrderedProduct orderedProduct : orderFromProducer){
            productsOrderedFromProducer.add(orderedProduct);
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GlutenFreeShop that = (GlutenFreeShop) o;
        return Objects.equals(producerName, that.producerName) &&
                Objects.equals(producerAddress, that.producerAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producerName, producerAddress);
    }
}
