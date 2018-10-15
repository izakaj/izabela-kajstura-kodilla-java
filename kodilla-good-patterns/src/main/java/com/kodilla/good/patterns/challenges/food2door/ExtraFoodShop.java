package com.kodilla.good.patterns.challenges.food2door;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ExtraFoodShop implements Producer {

    private String producerName = "ExtraFoodShop";
    private String producerAddress = "Diagon Alley 93, London";
    List<OrderedProduct> productsOrderedFromProducer = new LinkedList<>();

    public boolean process(List<OrderedProduct> orderFromProducer){
        System.out.println("Products from ExtraFoodShop are on their way!");
        for (OrderedProduct orderedProduct : orderFromProducer){
            productsOrderedFromProducer.add(orderedProduct);
        }
        return true;
    }

    public String getProducerName() {
        return producerName;
    }

    public String getProducerAddress() {
        return producerAddress;
    }

    public List<OrderedProduct> getProductsOrderedFromProducer() {
        return productsOrderedFromProducer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraFoodShop that = (ExtraFoodShop) o;
        return Objects.equals(producerName, that.producerName) &&
                Objects.equals(producerAddress, that.producerAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producerName, producerAddress);
    }
}
