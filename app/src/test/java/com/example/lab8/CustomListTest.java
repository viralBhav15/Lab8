package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCities(){
        // Initialize CityList with a few cities
        CustomList cityList = MockCityList();
        City city1 = new City("Calgary", "Alberta");
        City city2 = new City("Toronto", "Ontario");

        cityList.addCity(city1);

        assertTrue(cityList.hasCity(city1), "CityList should contain Calgary");
        assertFalse(cityList.hasCity(city2), "CityList should not contain Toronto");
    }

    @Test
    void testDeleteCity(){
        CustomList citylist = MockCityList();
        City city1 = new City("Miami", "Florida");

        citylist.addCity(city1);
        assertTrue(citylist.hasCity(city1));

        citylist.delete(city1);

        assertFalse(citylist.hasCity(city1));
    }

    @Test
    void testCountCity(){
        CustomList cityList = MockCityList();
        //assertEquals(1, cityList.countCities());

        City city1 = new City("Vancouver", "British Columbia");
        cityList.addCity(city1);

        assertEquals(1, cityList.countCities());

        City city2 = new City("Victoria", "British Columbia");
        City city3 = new City("Kelowna", "British Columbia");

        cityList.addCity(city2);
        cityList.addCity(city3);

        assertEquals(3, cityList.countCities());

    }
}
