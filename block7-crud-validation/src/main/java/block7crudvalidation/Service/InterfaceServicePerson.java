package block7crudvalidation.Service;

import block7crudvalidation.Entity.Person;

import java.util.List;
import java.util.Optional;

public interface InterfaceServicePerson {


    // this method add object person to BB DD
    Person addPerson(Person person);

    //This method get object from BB DD trow us id
    //Optional is for prevent error nullpointerexception
    Optional<Person> getPerson(Long id);

    //This method get object from BB DD trow us name
    //List is for get one o more dates from BB DD
    List<Person> getPersonByNames(String users);


    List<Person>getAllPerson();

    //This method update the BB DD where id=id
    Person updatePerson(Long id, Person person);

    // This method delete Person where id=id
    boolean deletePerson (Long id);
}
