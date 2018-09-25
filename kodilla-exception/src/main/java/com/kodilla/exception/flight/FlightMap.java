package com.kodilla.exception.flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlightMap {
    private final Map<String, List<String>> flights;

    public FlightMap(Map<String, List<String>> flights) {
        this.flights = flights;
    }

    public boolean isFlightPossible(String from, String to) {
        List<String> alreadyChecked = new ArrayList<>();
        alreadyChecked.add(from);
        List<String> yourRoute = new ArrayList<>();
        yourRoute.add(from);

        boolean result = isFlightPossible(from, to, alreadyChecked, yourRoute);
        if (result == true) System.out.println("Your route: " + yourRoute);
        return result;
    }

    private boolean isFlightPossible(String from, String to, List<String> alreadyChecked, List<String> yourRoute){

        boolean result = false;

        if(flights.containsKey(from)){

            List<String> temp = flights.get(from);

            for(String airport : temp){

                if(airport.equals(to)){
                    System.out.println("GOT IT");
                    yourRoute.add(airport);
                    return true;
                }
            }

            for(String airport : temp){
                if(alreadyChecked.contains(airport) == false){
                    yourRoute.add(airport);
                    alreadyChecked.add(airport);
                    if (isFlightPossible(airport, to, alreadyChecked, yourRoute)){
                        return true;
                    } else {
                        yourRoute.remove(airport);
                    }
                }
            }


        }

        return false;
    }
}
