package com.kodilla.good.patterns.challenges.food2door;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class OrderService {

    public Map<Producer, List<OrderedProduct>> process(final Order order){
        List<Producer> listOfProducers = new ArrayList<>();
        listOfProducers = order.getListOfOrderedProducts().stream()
               .map(o -> o.getProducer())
                .distinct()
                .collect(Collectors.toList());

        Map<Producer, List<OrderedProduct>> orderedProductsByProducer = new HashMap<>();

        for(Producer producer : listOfProducers){
            List<OrderedProduct> orderFromProducer = new ArrayList<>();
            orderFromProducer = order.getListOfOrderedProducts().stream()
                    .filter(o -> o.getProducer().equals(producer))
                    .collect(Collectors.toList());
            orderedProductsByProducer.put(producer, orderFromProducer);
            producer.process(orderFromProducer);
            System.out.println();
        }

        System.out.println("Success! The order has been processed.");

        BigDecimal totalPrice = order.getListOfOrderedProducts().stream()
                .map(p -> p.getProduct().getProductPrice().multiply(new BigDecimal(p.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total price: " + totalPrice);

        return orderedProductsByProducer;
    }
}
