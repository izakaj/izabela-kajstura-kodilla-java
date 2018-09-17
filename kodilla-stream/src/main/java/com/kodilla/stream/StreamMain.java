package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import java.util.stream.*;

public class StreamMain {
    public static void main(String[] args) {
        /*
        System.out.println("Welcome to module 7 - Stream");

        Processor processor = new Processor();
        Executor codeToExecute = () -> System.out.println("This is an example text.");
        processor.execute(codeToExecute);

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
        */
        // Upiększanie tekstu

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String poem1 = "Thee, Lithuania, I sing, my native land.\n" +
                "Thou art like health, for he can only understand\n" +
                "Thy merit and thy worth who lost thee long ago.\n" +
                "My pen now limns thy beauty, for I miss thee so.";
        String poem2 = "Give me dominion over souls! I despise this dead structure\n" +
                "Called the world, so endlessly praised by the rabble,\n" +
                "And whether I can destroy it by my words\n" +
                "I have yet to discover.";
        String poem3 = "The wick, touched by the spark, burns first and blinks \n" +
                "Melting the wax which climbs up curlicue. \n" +
                "A luminous star then slowly sinks. \n" +
                "Pale is its brightness, pale and blue.";

        String poemWIP = poem1;

        poemWIP = poemBeautifier.beautify(poemWIP, (a) -> {
            String temp = "";
            for (int i = 0; i < a.length(); i++) {
                if (i % 2 == 0) {
                    temp += a.substring(i, i + 1).toUpperCase();
                } else {
                    temp += a.substring(i, i + 1);
                }
            }
            return temp;
        });

        System.out.println();

        poemWIP = poemBeautifier.beautify(poemWIP, (a) -> {
            String temp = "";
            for (int i = 0; i < a.length(); i++){
                if(a.substring(i, i+1).equals("\n")){
                    temp += " :) :* :D \n";
                } else {
                    temp += a.substring(i, i+1);
                }
            }
            return temp;
                }
                );

        System.out.println();

        poemWIP = poemBeautifier.beautify(poemWIP, (a) -> {
                    String temp = "";
                    for (int i = 0; i < a.length(); i++){
                        if(a.substring(i, i+1).equals(",")){
                            temp += " @#*%!!, ";
                        } else {
                            temp += a.substring(i, i+1);
                        }
                    }
                    return temp;
                }
        );

        System.out.println();

        poemWIP = poemBeautifier.beautify(poemWIP, (a) -> {
                    String temp = "";
                    for (int i = 0; i < a.length(); i++){
                        if(a.substring(i, i+1).equals("s") || a.substring(i, i+1).equals("S")) {
                            temp += "$";
                        } else if(a.substring(i, i+1).equals("b") || a.substring(i, i+1).equals("B")) {
                            temp += "|3";
                        } else if(a.substring(i, i+1).equals("a") || a.substring(i, i+1).equals("A")) {
                            temp += "@";
                        } else {
                            temp += a.substring(i, i+1);
                        }
                    }
                    return temp;
                }
        );

        System.out.println();

        poemWIP = poemBeautifier.beautify(poemWIP, (a) -> a + " \\(ツ)/");

    }
}
