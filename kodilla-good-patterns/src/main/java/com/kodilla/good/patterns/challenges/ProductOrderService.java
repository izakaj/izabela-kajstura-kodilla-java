package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    private InformationService informationService;
    private OrdersToBeProcessed ordersToBeProcessed;
    private AllProductsList allProductsList;

    public ProductOrderService(InformationService informationService, OrdersToBeProcessed ordersToBeProcessed) {
        this.informationService = informationService;
        this.ordersToBeProcessed = ordersToBeProcessed;
    }

    public TransactionDto newOrder(final Order order){
        boolean isAvailable = allProductsList.checkAvailability(order);

        if(isAvailable){
            informationService.inform(order.getUser());
            ordersToBeProcessed.addOrder(order);
            return new TransactionDto(order, true);
        } else{
            return new TransactionDto(order, false);
        }

    }
}
