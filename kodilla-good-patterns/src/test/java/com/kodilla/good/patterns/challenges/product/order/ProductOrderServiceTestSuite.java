package com.kodilla.good.patterns.challenges.product.order;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductOrderServiceTestSuite {

    @Test
    public void testNewOrder(){
        //Given
        Map<Product, Integer> productMap1 = new HashMap<Product, Integer>(){{
            put(new Product(1, "The One Ring",
                    new BigDecimal("99.99")), new Integer(1));
            put(new Product(2, "Rings for Elven-kings",
                    new BigDecimal("68.50")), new Integer(3));
            put(new Product(3, "Rings for Dwarf-lords",
                    new BigDecimal("50.00")), new Integer(7));
            put(new Product(4, "Rings for Mortal Men doomed to die",
                    new BigDecimal("19.99")), new Integer(9));
        }};
        Order order1 = new Order(new User("Bilbo", "Baggins",
                "baggins@bagend.me", "759 684 123"), productMap1);
        ProductOrderService productOrderService = new ProductOrderService(new MailService(),
                new OrdersToBeProcessed());

        //When
        TransactionDto transactionDto = productOrderService.newOrder(order1);

        //Then
        Assert.assertTrue(productOrderService.getOrdersToBeProcessed().getListOfOrders().size() == 1);

    }
}
