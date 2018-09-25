package com.kodilla.exception.flight;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        final Map<String, List<String>> flights = new HashMap<>();

        flights.put("warsaw", Arrays.asList("berlin", "london", "prague"));
        flights.put("london", Arrays.asList("new york"));
        flights.put("new york", Arrays.asList("london", "los angeles", "warsaw"));
        flights.put("prague", Arrays.asList("rome", "petersburg"));
        flights.put("los angeles", Arrays.asList("chicago"));

        final FlightMap flightMap = new FlightMap(flights);


        boolean possible = flightMap.isFlightPossible("warsaw", "chicago");
        System.out.println("possible: " + possible);

        System.out.println();

        boolean possible2 = flightMap.isFlightPossible("warsaw", "petersburg");
        System.out.println("possible2: " + possible2);

        System.out.println();

        boolean possible3 = flightMap.isFlightPossible("london", "petersburg");
        System.out.println("possible3: " + possible3);

        System.out.println();

        boolean possible4 = flightMap.isFlightPossible("los angeles", "petersburg");
        System.out.println("possible4: " + possible4);

    }
}
