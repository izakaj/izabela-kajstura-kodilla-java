package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){

        System.out.println("Test dodawania");
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 7;
        if (calculator.addAToB(a, b) == 12) {
            System.out.println("test OK\n");
        } else {
            System.out.println("Error!\n");
        }

        System.out.println("Test odejmowania");
        if (calculator.subtractBFromA(a, b) == -2) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

    }
}
