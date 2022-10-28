package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    @BeforeEach
    public void MockCityList(){
        list = new CustomList(null,new ArrayList<>());
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    @DisplayName("This function if for testing add")
    public void addCityTest(){
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    @DisplayName("This function if for testing hasCity")
    void testHasCity() {
        City city = new City("Regina", "Saskatchewan");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    @DisplayName("This function if for testing delete")
    void testDelete() {
        int listSize = list.getCount();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertEquals(list.getCount(),listSize + 1);
        list.deleteCity(city);
        assertEquals(list.getCount(),listSize);
    }

    @Test
    @DisplayName("This function if for testing delete exception")
    void testDelete2() {
        assertThrows(IllegalArgumentException.class, ()->list.deleteCity(new City("Estevan", "SK")));
    }

    @Test
    @DisplayName("This function if for testing countCities")
    void testCountCities() {
        int listSize = list.countCities();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertEquals(list.countCities(),listSize + 1);
        list.deleteCity(city);
        assertEquals(list.countCities(),listSize);
    }
}
