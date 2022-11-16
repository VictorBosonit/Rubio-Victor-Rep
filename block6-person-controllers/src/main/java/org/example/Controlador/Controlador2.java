package org.example.Controlador;


import org.example.Model.City;
import org.example.Model.Person;
import org.example.Service.ServicePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class Controlador2 {
    @Autowired
    ServicePerson servicePerson;


    //method for get Person from HTTP
    @PostMapping("/getPerson")
    public Person insertPerson2(@RequestBody  Person person) {

        Person person1 =new Person(person.getName(),person.getAge()*2, person.getCity());

        return servicePerson.insertPerson(person1);
    }

    // method for get all cities from the list
    @GetMapping("/getcity")
    public List <City> getCity() {
        return servicePerson.getCity();
    }

    // method for get all person from the list
    @GetMapping("/getPersons")
    public List <Person> getPerson() {
        return servicePerson.gettPerson();
    }
}