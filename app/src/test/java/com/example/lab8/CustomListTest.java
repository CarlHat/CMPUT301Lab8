package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;

public class CustomListTest {
//    @BeforeEach
//    private void mockCityList() {
//        cityList = new CityList();
//        cityList.add(mockCity());
////        return cityList;
//    }
//    private City mockCity() {
//        return new City("Edmonton", "Alberta");
//    }

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

//    @Test
//    void testAdd2() {
//        City city = mockCity();
//        cityList.add(city);
//        assertThrows(IllegalArgumentException.class, ()->cityList.add(city));
//    }
//    @Test
//    @EnabledOnOs(OS.WINDOWS)
////    @EnabledIf(true)
//    @RepeatedTest(10)
//    void testGetCities() {
//        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
//        City city = new City("Calgary", "AB");
//        assertTimeout(Duration.ofSeconds(1), ()->{
//            cityList.add(city);
//
//        });
//        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
//        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
//    }
//
//    @Test
//    @DisplayName("This function if for testing hasCity")
//    void testHasCity() {
//        City city = new City("Regina", "Saskatchewan");
//        assertFalse(cityList.hasCity(city));
//        cityList.add(city);
//        assertTrue(cityList.hasCity(city));
//    }
//
//    @Test
//    @DisplayName("This function if for testing delete")
//    void testDelete() {
//        assertEquals(1, cityList.getCities().size());
//        City city = new City("Regina", "Saskatchewan");
//        cityList.add(city);
//        assertEquals(2, cityList.getCities().size());
//        cityList.delete(city);
//        assertEquals(1, cityList.getCities().size());
//    }
//    @Test
//    void testDelete2() {
//        City city = mockCity();
//        assertThrows(IllegalArgumentException.class, ()->cityList.delete(city));
//    }
//
//    @Test
//    @DisplayName("This function if for testing countCities")
//    void testCountCities() {
//        assertEquals(1, cityList.countCities());
//        City city = new City("Regina", "Saskatchewan");
//        cityList.add(city);
//        assertEquals(2, cityList.countCities());
//        cityList.delete(city);
//        assertEquals(1, cityList.countCities());
//    }

}
