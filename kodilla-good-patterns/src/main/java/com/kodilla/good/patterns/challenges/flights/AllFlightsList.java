package com.kodilla.good.patterns.challenges.flights;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
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
                .filter(f -> f.getFrom().equals(airportOfOrigin))
                .collect(Collectors.toList());
        return allFlightsFrom;
    }

    public List<Flight> findFlightsTo(String destinationAirport){
        List<Flight> allFlightsTo = getListOfFlights().stream()
                .filter(f -> f.getTo().equals(destinationAirport))
                .collect(Collectors.toList());
        return allFlightsTo;
    }

    public Optional<Flight> findFlightFromAToB(String airportOrOrigin, String destinationAirport){
        Flight searchedFlight = new Flight(airportOrOrigin, destinationAirport);

        Optional<Flight> flight = getListOfFlights().stream()
                .filter(f -> airportOrOrigin.equals(f.getFrom()) &&
                        destinationAirport.equals(f.getTo()))
                .findAny();

        return flight;
    }

    public List<List<Flight>> indirectFlightsFromAToB(String airportOfOrigin, String destinationAirport){
        List<String> flightThrough = getListOfFlights().stream()
                .filter(f -> f.getFrom().equals(airportOfOrigin))
                .map(f -> findFlightsFrom(f.getTo()))
                .flatMap(f -> f.stream())
                .filter(f -> f.getTo().equals(destinationAirport))
                .map(f -> f.getFrom())
                .collect(Collectors.toList());
        List<List<Flight>> indirectFlights = new LinkedList<>();
        for(String airport : flightThrough){
            if((findFlightFromAToB(airportOfOrigin, airport).isPresent() &&
                    findFlightFromAToB(airport, destinationAirport).isPresent()))
                        indirectFlights.add(new LinkedList<Flight>(){{
                            add(findFlightFromAToB(airportOfOrigin, airport).get());
                            add(findFlightFromAToB(airport, destinationAirport).get());
                        }});
        }
        System.out.println(indirectFlights.size() == 0 ?
                "Sorry, could not find indirect flights." : indirectFlights);
        return indirectFlights;
    }


    public List<Flight> getListOfFlights() {
        return listOfFlights;
    }
}
