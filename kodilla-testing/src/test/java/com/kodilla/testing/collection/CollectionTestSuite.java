package com.kodilla.testing.collection;

import org.junit.*;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CollectionTestSuite {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before(){
        System.out.println("Starting Test Case: " + name.getMethodName());
    }

    @After
    public void after(){
        System.out.println("Test Case " + name.getMethodName() + " end");
    }


    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> numbers = new ArrayList<>();
        //When
        List<Integer> result = oddNumbersExterminator.exterminate(numbers);
        //Then
        Assert.assertNull(result);
    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        Random r = new Random(3);
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i < 20; i++){
            numbers.add(i);
        }

        //When
        List<Integer> evenNumbers = new ArrayList<>();
        for (int i=0; i<10; i++){
            evenNumbers.add(i * 2);
        }
        List<Integer> result = oddNumbersExterminator.exterminate(numbers);

        //Then
        Assert.assertEquals(evenNumbers, result);
    }
}
