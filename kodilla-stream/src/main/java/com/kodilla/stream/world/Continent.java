package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final String continentName;
    private final List<Country> listOfCountries = new ArrayList<>();

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public void addCountry(Country country){
        listOfCountries.add(country);
    }

    public boolean removeCountry(Country country){
        return listOfCountries.remove(country);
    }

    public List<Country> getListOfCountries() {
        return listOfCountries;
    }

    public String getContinentName() {
        return continentName;
    }
}
