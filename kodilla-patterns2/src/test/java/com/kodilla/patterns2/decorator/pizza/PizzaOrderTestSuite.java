package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {

    @Test
    public void testPizzaWithHamAndOnion() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HamDecorator(theOrder);
        theOrder = new OnionDecorator(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();
        String description = theOrder.getDescription();
        System.out.println("Ordered: " + description);

        //Then
        assertEquals(new BigDecimal("21.5"), theCost);
        assertEquals("Pizza + ham + onion", description);
    }

    @Test
    public void testPizzaWithChickenSpinachAndGarlicSauce() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ChickenDecorator(theOrder);
        theOrder = new SpinachDecorator(theOrder);
        theOrder = new GarlicSauceDecorator(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();
        String description = theOrder.getDescription();
        System.out.println("Ordered: " + description);

        //Then
        assertEquals(new BigDecimal("25.5"), theCost);
        assertEquals("Pizza + chicken + spinach + garlic sauce", description);
    }

    @Test
    public void testPizzaWithChickenBroccoliAndExtraCheese() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ChickenDecorator(theOrder);
        theOrder = new BroccoliDecorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();
        String description = theOrder.getDescription();
        System.out.println("Ordered: " + description);

        //Then
        assertEquals(new BigDecimal("24.5"), theCost);
        assertEquals("Pizza + chicken + broccoli + extra cheese", description);
    }

    @Test
    public void testPizzaWithHamSpinachBroccoliAndGarlicSauce() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HamDecorator(theOrder);
        theOrder = new SpinachDecorator(theOrder);
        theOrder = new BroccoliDecorator(theOrder);
        theOrder = new GarlicSauceDecorator(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();
        String description = theOrder.getDescription();
        System.out.println("Ordered: " + description);

        //Then
        assertEquals(new BigDecimal("27.5"), theCost);
        assertEquals("Pizza + ham + spinach + broccoli + garlic sauce", description);
    }
}