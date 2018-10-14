package com.kodilla.good.patterns.challenges.product.order;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        OrderRetriever orderRetriever = new OrderRetriever();
        Order order = orderRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(new MailService(),
                new OrdersToBeProcessed());

        TransactionDto transactionDto = productOrderService.newOrder(order);

        System.out.println(transactionDto.getOrder() + " - processed: " + transactionDto.getIsProcessed());
    }
}
