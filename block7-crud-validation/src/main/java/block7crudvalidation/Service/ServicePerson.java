package block7crudvalidation.Service;

import block7crudvalidation.Entity.Person;
import block7crudvalidation.Repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicePerson implements  InterfaceServicePerson{

private final PersonRepository personRepository;


    @Override
    public Person addPerson(Person person) {
        return null;
    }

    @Override
    public Optional<Person> getPerson(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Person> getPersonByNames(String users) {
        return null;
    }

    @Override
    public List<Person> getAllPerson() {
        return null;
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        return null;
    }

    @Override
    public boolean deletePerson(Long id) {
        return false;
    }
}
