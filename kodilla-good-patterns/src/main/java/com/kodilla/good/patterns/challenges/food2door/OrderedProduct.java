package com.kodilla.good.patterns.challenges.food2door;

public class OrderedProduct {
    private final Producer producer;
    private final Product product;
    private int quantity;

    public OrderedProduct(Producer producer, Product product, int quantity) {
        this.producer = producer;
        this.product = product;
        this.quantity = quantity;
    }

    public Producer getProducer() {
        return producer;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderedProduct{" +
                "producer=" + producer +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
