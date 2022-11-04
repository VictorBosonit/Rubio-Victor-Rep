package org.example.Service;


import org.example.Objeto.City;
import org.example.Objeto.Person;
import org.example.Repository.RepositoryCity;
import org.example.Repository.RepositoryPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServicePerson {


    @Autowired
    RepositoryPerson repositoryPerson;
    @Autowired
    RepositoryCity repositoryCity;

    public Person insertPerson(Person person) {
        repositoryPerson.insertPerson(person);
        return person;
    }

    public City insertCity(City city) {
        repositoryCity.insertCity(city);
        return city;
    }



    public List<City> getCity (){
        return  repositoryCity.gettCity();
    }

    public List<Person> gettPerson (){
        return  repositoryPerson.gettPerson();
    }

}
