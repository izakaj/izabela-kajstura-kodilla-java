package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){

        // pierwszy test - Simple User

        System.out.println("Test SimpleUser");

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK\n");
        } else {
            System.out.println("Error!\n");
        }

        // testy kalkulatora

        System.out.println("Test dodawania");

        Calculator calculator = new Calculator();

        int a = 5;
        int b = 7;

        if(calculator.addAToB(a, b) == a + b) {
            System.out.println("test OK\n");
        } else {
            System.out.println("Error!\n");
        }

        System.out.println("Test odejmowania");

        if(calculator.subtractBFromA(a, b) == a - b) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }


    }
}
