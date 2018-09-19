package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){
        //Given
        int[] numbers = new int[]{12, 50, 36, 78, 45, 67, 3, 11, 26, 84};

        //When
        double average = ArrayOperations.getAverage(numbers);

        //Then
        Assert.assertEquals(41.2, average, 0.001);
    }

    @Test
    public void testGetAverageEmptyArray(){
        //Given
        int[] numbers = new int[0];

        //When
        double average = ArrayOperations.getAverage(numbers);

        //Then
        Assert.assertEquals(0, average, 0.001);
    }
}
