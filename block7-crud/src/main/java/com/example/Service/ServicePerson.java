package com.example.Service;


import com.example.Object.Person;
import com.example.Repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


// This the class Service for communicate Controller and Repository trow us Interface
@Service
@AllArgsConstructor
public class ServicePerson implements  InterfaceServicePerson{


    private final PersonRepository personRepository;


    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> getPerson(Long id) {
        return Optional.ofNullable(personRepository.findById(id)).orElseThrow(() -> {
            throw new RuntimeException();
        });
    }

    @Override
    public List<Person> getPersonByNames(String name) {
        return  personRepository.findbyName(name);
    }


    @Override
    public Person updatePerson(Long id, Person personUpdate) {
        // we create a new object and then pass the parameter from controller
        Person personFind = personRepository.findById(id).get();

        personFind.setAge(personUpdate.getAge());
        personFind.setName(personUpdate.getName());
        personFind.setCity(personUpdate.getCity());

        return personRepository.save(personFind);
    }


    @Override
    public boolean deletePerson(Long id) {

        try {
            personRepository.deleteById(id);
        } catch (Exception e) {

        }
        return false;
    }



}
