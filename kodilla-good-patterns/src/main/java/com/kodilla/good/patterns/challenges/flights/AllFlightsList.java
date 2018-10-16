package com.kodilla.good.patterns.challenges.flights;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public final class AllFlightsList {

    final List<Flight> listOfFlights = new LinkedList<>();

    public AllFlightsList() {
        listOfFlights.add(new Flight("Warsaw", "Cracow"));
        listOfFlights.add(new Flight("Warsaw", "Gdansk"));
        listOfFlights.add(new Flight("Warsaw", "Wroclaw"));
        listOfFlights.add(new Flight("Wroclaw", "Katowice"));
        listOfFlights.add(new Flight("Wroclaw", "New York"));
        listOfFlights.add(new Flight("Warsaw", "Katowice"));
        listOfFlights.add(new Flight("Katowice", "Warsaw"));
        listOfFlights.add(new Flight("Gdansk", "Cracow"));
        listOfFlights.add(new Flight("Gdansk", "Poznan"));
        listOfFlights.add(new Flight("Cracow", "Warsaw"));
        listOfFlights.add(new Flight("Katowice", "Poznan"));
    }

    public List<Flight> findFlightsFrom(String airportOfOrigin){
        List<Flight> allFlightsFrom = getListOfFlights().stream()
                .filter(f -> f.getFlightFrom().equals(airportOfOrigin))
                .collect(Collectors.toList());
        return allFlightsFrom;
    }

    public List<Flight> findFlightsTo(String destinationAirport){
        List<Flight> allFlightsTo = getListOfFlights().stream()
                .filter(f -> f.getFlightTo().equals(destinationAirport))
                .collect(Collectors.toList());
        return allFlightsTo;
    }

    public Flight findFlightFromAToB(String airportOrOrigin, String destinationAirport){
        Flight searchedFlight = new Flight(airportOrOrigin, destinationAirport);

        Flight flight = getListOfFlights().stream()
                .filter(f -> airportOrOrigin.equals(f.getFlightFrom()) &&
                        destinationAirport.equals(f.getFlightTo()))
                .findAny()
                .orElse(new Flight("", ""));

        return flight;
    }

    public List<List<Flight>> indirectFlightsFromAToB(String airportOfOrigin, String destinationAirport){
        List<String> flightThrough = getListOfFlights().stream()
                .filter(f -> f.getFlightFrom().equals(airportOfOrigin))
                .map(f -> findFlightsFrom(f.getFlightTo()))
                .flatMap(f -> f.stream())
                .filter(f -> f.getFlightTo().equals(destinationAirport))
                .map(f -> f.getFlightFrom())
                .collect(Collectors.toList());
        List<List<Flight>> indirectFlights = new LinkedList<>();
        for(String airport : flightThrough){
            if(!(findFlightFromAToB(airportOfOrigin, airport).equals(new Flight("", "")) ||
                    findFlightFromAToB(airport, destinationAirport).equals(new Flight("", ""))))
                        indirectFlights.add(new LinkedList<Flight>(){{
                            add(findFlightFromAToB(airportOfOrigin, airport));
                            add(findFlightFromAToB(airport, destinationAirport));
                        }});
        }
        System.out.println(indirectFlights);
        return indirectFlights;
    }


    public List<Flight> getListOfFlights() {
        return listOfFlights;
    }
}
