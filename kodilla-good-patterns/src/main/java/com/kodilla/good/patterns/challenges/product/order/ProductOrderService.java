package com.kodilla.good.patterns.challenges.product.order;

public class ProductOrderService {

    private InformationService informationService;
    private OrdersToBeProcessed ordersToBeProcessed;
    private AllProductsList allProductsList = new AllProductsList();

    public InformationService getInformationService() {
        return informationService;
    }

    public OrdersToBeProcessed getOrdersToBeProcessed() {
        return ordersToBeProcessed;
    }

    public AllProductsList getAllProductsList() {
        return allProductsList;
    }

    public ProductOrderService(InformationService informationService, OrdersToBeProcessed ordersToBeProcessed) {
        this.informationService = informationService;
        this.ordersToBeProcessed = ordersToBeProcessed;
    }

    public TransactionDto newOrder(final Order order){
        boolean isAvailable = allProductsList.checkAvailability(order);

        if(isAvailable){
            if(ordersToBeProcessed.addOrder(order)){
                informationService.inform(order.getUser(), "Your order is processed.");
            }else{
                informationService.inform(order.getUser(), "Your order cannot be processed.");
            }
            return new TransactionDto(order, true);
        } else{
            return new TransactionDto(order, false);
        }

    }
}
