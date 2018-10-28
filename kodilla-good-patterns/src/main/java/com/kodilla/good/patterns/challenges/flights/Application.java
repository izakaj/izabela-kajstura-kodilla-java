package com.kodilla.good.patterns.challenges.flights;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        AllFlightsList allFlightsList = new AllFlightsList();

        String airportOfOrigin = "Warsaw";
        List<Flight> fligthsFromA = allFlightsList.findFlightsFrom(airportOfOrigin);
        System.out.println("All flights from: " + airportOfOrigin + '\n' + fligthsFromA + '\n');

        String destinationAirport = "Warsaw";
        List<Flight> flightsToB = allFlightsList.findFlightsTo("Warsaw");
        System.out.println("All flights to: " + destinationAirport + '\n' + flightsToB + '\n');

        System.out.println("Indirect flights from Warsaw to Poznan:");
        List<List<Flight>> indirectFlightsFromAToB =
                allFlightsList.indirectFlightsFromAToB("Warsaw",
                        "Poznan");

        System.out.println("\nIndirect flights from Katowice to New York:");
        List<List<Flight>> indirectFlightsFromAToB2 =
                allFlightsList.indirectFlightsFromAToB("Katowice",
                        "New York");

    }
}
