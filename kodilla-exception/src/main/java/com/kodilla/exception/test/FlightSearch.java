package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public void findFlight(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> flightsMap = new HashMap<>();
        flightsMap.put("Cologne", true);
        flightsMap.put("Hamburg", true);
        flightsMap.put("Vienna", false);
        flightsMap.put("Helsinki", true);
        flightsMap.put("Copenhagen", false);
        flightsMap.put("Amsterdam", true);
        flightsMap.put("Frankfurt", true);

        if(flightsMap.containsKey(flight.getArrivalAirport()) &&
                flightsMap.get(flight.getArrivalAirport()) == true){
            System.out.println("You can fly to: " + flight.getArrivalAirport());
        } else {
            throw new RouteNotFoundException("Route was not found - arrival airport unavailable.");
        }
    }

}
