package org.example.Repository;

import org.example.Objeto.City;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryCity {

    private static List<City> city= new ArrayList<City>(); // list for acumulate diferent object of cities

    public void insertCity(City citys) {city.add(citys);} // witch this method we add more cities to the list
    public List<City> gettCity() {
            return city;
    } // witch this method get the complet list of cities

}
