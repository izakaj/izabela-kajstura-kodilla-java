package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BroccoliDecorator extends AbstractPizzaOrderDecorator {
    public BroccoliDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + broccoli";
    }
}
