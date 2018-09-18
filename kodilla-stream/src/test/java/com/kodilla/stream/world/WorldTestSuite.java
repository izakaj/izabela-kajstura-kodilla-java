package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){
        //Given
        World world = new World();
        Continent europe = new Continent("Europe");
        Continent northAmerica = new Continent("North America");
        Continent australia = new Continent("Australia");
        europe.addCountry(new Country("Kabuto", new BigDecimal("7228")));
        europe.addCountry(new Country("Liberland", new BigDecimal("0")));
        europe.addCountry(new Country("Filettino", new BigDecimal("554")));
        europe.addCountry(new Country("Ladonia", new BigDecimal("15000")));
        europe.addCountry(new Country("Sealand", new BigDecimal("2")));
        northAmerica.addCountry(new Country("San Escobar", new BigDecimal("360000")));
        northAmerica.addCountry(new Country("Conch Republic", new BigDecimal("97")));
        northAmerica.addCountry(new Country("Vikesland", new BigDecimal("26")));
        northAmerica.addCountry(new Country("Talossa", new BigDecimal("200")));
        australia.addCountry(new Country("Atlantium", new BigDecimal("903")));
        australia.addCountry(new Country("Hutt River", new BigDecimal("30")));
        world.addContinent(europe);
        world.addContinent(northAmerica);
        world.addContinent(australia);

        //When
        BigDecimal allThePeople = world.getListOfContinents().stream()
                .flatMap(continent -> continent.getListOfCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("384040");
        Assert.assertEquals(expectedPeopleQuantity, allThePeople);


    }
}
