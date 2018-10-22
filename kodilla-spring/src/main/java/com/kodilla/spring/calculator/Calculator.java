package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class Calculator {

    @Autowired
    private Display display;

    public double add(double a, double b){
        double val = a + b;
        display.displayValue(val);
        return val;
    }

    public double sub(double a, double b){
        double val = a - b;
        display.displayValue(val);
        return val;
    }

    public double mul(double a, double b){
        double val = a * b;
        display.displayValue(val);
        return val;
    }

    public double div(double a, double b){
        if(b == 0) {
            System.out.println("Can't divide by 0!");
            return 0;
        }
        double val = a / b;
        display.displayValue(val);
        return val;
    }
}
