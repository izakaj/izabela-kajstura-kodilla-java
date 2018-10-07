package com.kodilla.good.patterns.challenges;

public class TransactionDto {
    private Order order;
    private boolean isProcessed;

    public TransactionDto(Order order, boolean isProcessed) {
        this.order = order;
        this.isProcessed = isProcessed;
    }

    public Order getOrder() {
        return order;
    }

    public boolean isProcessed() {
        return isProcessed;
    }
}
