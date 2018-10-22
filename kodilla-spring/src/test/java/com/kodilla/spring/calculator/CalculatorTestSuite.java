package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        double a = 20;
        double b = 5;
        //When
        double resultAdd = calculator.add(a, b);
        double resultSub = calculator.sub(a, b);
        double resultMul = calculator.mul(a, b);
        double resultDiv = calculator.div(a, b);
        //Then
        Assert.assertEquals(25, resultAdd, 0.01);
        Assert.assertEquals(15, resultSub, 0.01);
        Assert.assertEquals(100, resultMul, 0.01);
        Assert.assertEquals(4, resultDiv, 0.01);
    }

    @Test
    public void testDivisionByZero(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        double a = 20;
        double b = 5;
        //When
        double result = calculator.div(a, b);
        //Then
        Assert.assertEquals(0, result, 0.01);
    }
}
