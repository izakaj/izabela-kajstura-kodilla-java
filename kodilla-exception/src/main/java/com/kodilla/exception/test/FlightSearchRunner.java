package com.kodilla.exception.test;

public class FlightSearchRunner {

    public static void main(String args[]){
        Flight flight1 = new Flight("Cracow", "Cologne");
        Flight flight2 = new Flight("Cracow", "Vienna");
        Flight flight3 = new Flight("Cracow", "Pisa");

        FlightSearch flightSearch = new FlightSearch();

        try {
            flightSearch.findFlight(flight1);
        } catch(RouteNotFoundException e){
            System.out.println("Route not found - you can't fly to: " + flight1.getArrivalAirport());
        } finally {
            System.out.println("Search ended");
        }

        try {
            flightSearch.findFlight(flight2);
        } catch(RouteNotFoundException e){
            System.out.println("Route not found - you can't fly to: " + flight2.getArrivalAirport());
        } finally {
            System.out.println("Search ended");
        }

        try {
            flightSearch.findFlight(flight3);
        } catch(RouteNotFoundException e){
            System.out.println("Route not found - you can't fly to: " + flight3.getArrivalAirport());
        } finally {
            System.out.println("Search ended");
        }

    }
}
