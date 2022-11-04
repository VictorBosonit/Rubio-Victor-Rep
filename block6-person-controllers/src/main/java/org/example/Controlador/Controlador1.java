package org.example.Controlador;


import org.example.Objeto.City;
import org.example.Objeto.Person;
import org.example.Service.ServicePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador1 {

    @Autowired
    ServicePerson servicePerson;

    // method for add person from http
    @PostMapping("/addPerson")
    public Person insertPerson(@RequestBody  Person person) {
        return servicePerson.insertPerson(person);
    }

    // method for add city from http
    @PostMapping("/addcity")
    public City insertCity(@RequestBody  City city) {
        return servicePerson.insertCity(city);
    }

}
