package com.kodilla.good.patterns.challenges.product.order;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AllProductsList {

    List<Product> listOfAllProducts = new LinkedList<>();

    public boolean checkAvailability(final Order order){
        final List<Product> listOfOrderedProducts = order.getProductsOrdered().entrySet().stream()
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        for(Product product : listOfOrderedProducts){
            if(!listOfAllProducts.contains(product)){
                return false;
            }
        }
        System.out.println("All products are available!");
        return true;
    }

    public AllProductsList() {
        listOfAllProducts.add(new Product(1, "The One Ring",
                new BigDecimal("99.99")));
        listOfAllProducts.add(new Product(2, "Rings for Elven-kings",
                new BigDecimal("68.50")));
        listOfAllProducts.add(new Product(3, "Rings for Dwarf-lords",
                new BigDecimal("50.00")));
        listOfAllProducts.add(new Product(4, "Rings for Mortal Men doomed to die",
                new BigDecimal("19.99")));
    }
}
