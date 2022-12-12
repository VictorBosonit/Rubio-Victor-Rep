package block7crudvalidation.person.aplication;

import block7crudvalidation.person.domain.Person;
import block7crudvalidation.person.infraestructure.controller.dto.input.InputPersonDto;
import block7crudvalidation.person.infraestructure.controller.dto.output.OutputPersonDto;
import block7crudvalidation.person.infraestructure.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
@AllArgsConstructor
public class ServicePerson implements  InterfaceServicePerson{

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public Person addPerson(Person personDto) {
        return null;
    }

    @Override
    public Person addPerson(InputPersonDto personDto) throws Exception {
        //I get an object type inputpersondto from RestController and
        // I mapped the inputpersonddto to Person object
        Person person ;
        try {
            if(!(personDto.getUsers()==null||personDto.getPassword()==null||personDto.getName() == null ||
                    personDto.getCompany_email() == null || personDto.getPersonal_email() == null || personDto.getCity() == null ||
                    personDto.getActive() == null || personDto.getUsers().length() > 10)){
                person = modelMapper.map(personDto, Person.class);
                // I get the date from system and add the date to Created_date and save
                // in database
                Date date = new Date();
                person.setCreated_date(date);
            }else{throw new UnsupportedOperationException() ;
            }
            return personRepository.save(person);
        } catch (Exception e) {
        throw new Exception(e.getMessage());
        }
    }


    @Override
    public Optional<OutputPersonDto> getPerson(Long id) throws Exception {
        // I search a new object type person in database, and then
        // I mapped the object person from database to object Outputpersondto
        OutputPersonDto dtoPerson = new OutputPersonDto();
        try {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()) {
            modelMapper.map(person, OutputPersonDto.class);
            //I put a new date in Termination_date when call this function and the value is not null
            Date date = new Date();
            dtoPerson.setTermination_date(date);
        }else{throw new EntityNotFoundException() ;}
            // I return an optional of object dtoPerson
            return  Optional.of(dtoPerson);

        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OutputPersonDto> getPersonByNames(String name) throws Exception {
        List<OutputPersonDto> dtoPerson = new ArrayList<>();
        try {
        // I get a list of object when I search by name it´s possible one or more object
        List<Person> person = personRepository.findByName(name);
        // I mapped the list of person to list of objects type outputPersonDto using
        // TypeToken (TypeToken is used to map generic parameterized types.)
         modelMapper.map(person, new TypeToken<List<OutputPersonDto>>(){}.getType());

        // I return a list of objects type OutputPersonDto
            return dtoPerson;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        return null;
    }

    @Override
    public boolean deletePerson(Long id) {
        return false;
    }

    @Override
    public List<OutputPersonDto> getAllPerson() throws Exception {

        List<OutputPersonDto> dtoPerson = new ArrayList<>();
        try {
        // I get a list of object when I call to method getAllPerson
        List<Person> person = personRepository.findAll();
        // I mapped the list of person to list of objects type outputPersonDto using
        // TypeToken (TypeToken is used to map generic parameterized types.)
        modelMapper.map(person, new TypeToken<List<OutputPersonDto>>(){}.getType());
            // I return a list of objects type OutputPersonDto
            return dtoPerson ;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
