package org.example.Repository;

import org.example.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryPerson {

    public static List<Person> person= new ArrayList<Person>();// list for acumulate diferent object of person

    public Person insertPerson(Person persona) {person.add(persona); // with this method we add more cities to the person
        return persona;
    }

    public List<Person> gettPerson() {
        return person;
    }// with this method we get the complet list of person

}
