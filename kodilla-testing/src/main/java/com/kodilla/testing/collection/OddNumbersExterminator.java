package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    private List<Integer> evenNumbers = new ArrayList<Integer>();

    public List<Integer> exterminate(List<Integer> numbers) {

        if(evenNumbers.size() != 0){
            evenNumbers.clear();
        }

        if(numbers.size() == 0){
            System.out.println("The list is empty!");
        } else {
            for (Integer number : numbers) {
                if (number % 2 == 0) {
                    evenNumbers.add(number);
                }
            }
        }
        return evenNumbers;
    }
}
