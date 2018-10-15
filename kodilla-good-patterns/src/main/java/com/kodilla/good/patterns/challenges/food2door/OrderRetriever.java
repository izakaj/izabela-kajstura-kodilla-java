package com.kodilla.good.patterns.challenges.food2door;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class OrderRetriever {

    public Order retrieve(){
        User user = new User(1, "Dumbledore", "Hogwarts",
                "headmaster@hogwarts.edu.co.uk");
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        HealthyShop healthyShop = new HealthyShop();
        List<OrderedProduct> listOfOrderedProducts = new LinkedList<>();
        listOfOrderedProducts.add(new OrderedProduct(extraFoodShop, new Product(1,
                "chickpea", new BigDecimal("23.50")), 5));
        listOfOrderedProducts.add(new OrderedProduct(healthyShop, new Product(2,
                "buckwheat", new BigDecimal("27.50")), 10));
        listOfOrderedProducts.add(new OrderedProduct(glutenFreeShop, new Product(3,
                "lentils", new BigDecimal("20.00")), 2));
        listOfOrderedProducts.add(new OrderedProduct(extraFoodShop, new Product(4,
                "potato starch", new BigDecimal("36.00")), 4));
        listOfOrderedProducts.add(new OrderedProduct(glutenFreeShop, new Product(5,
                "brown rice flour", new BigDecimal("60.00")), 8));

        return new Order(user, listOfOrderedProducts);



    }
}
